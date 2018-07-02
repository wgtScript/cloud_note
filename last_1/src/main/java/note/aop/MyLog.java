package note.aop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class MyLog {
	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(500);
	private File file;
	private Thread writer;
	private SimpleDateFormat sdf;
	
	public MyLog() {
		String aa=System.getProperty("user.dir");
		String log_path=aa+"/wgt_note.log";
		System.out.println(aa);
		file=new File(log_path);
		System.out.println(1);
		sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		writer = new Thread() {
			public void run() {
				while (true) {
					try {
						if (queue.isEmpty()) {
							//System.out.println("队列为空");
							Thread.sleep(10000);
							continue;
						}
						PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
						while(!queue.isEmpty()){
							//System.out.println("队列不为空");
							String str=queue.poll();
							out.println(str);
						}
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		writer.start();
	}
	
	@Around("execution(* note.service.*Service.*(..))")
	public Object proc(ProceedingJoinPoint joinPoint)throws Throwable{
		long t1=System.nanoTime();
		Object obj= joinPoint.proceed();
		long t2=System.nanoTime();
		Signature s=joinPoint.getSignature();
		
		String str="时间："+sdf.format(new Date(System.currentTimeMillis()))+"执行了  方法："+s+",\n耗时"+(t2-t1)/1000+"毫秒";
		System.out.println(str);
		queue.offer(str);
		return obj;
	}
	
}
