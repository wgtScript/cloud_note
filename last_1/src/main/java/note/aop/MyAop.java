package note.aop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
	@AfterThrowing(pointcut="within(note.controller..*)",throwing="e")
	public void test3(Exception e){
		
		System.out.println("异常");
	}
	//@Before("bean(userController)")
	public void test(){
		System.out.println("controller执行前");
	}
	//@Around("execution(* note.service.*Service.*(..))")
	public Object test4(ProceedingJoinPoint joinPoint) throws Throwable{
		
		long t1=System.nanoTime();
		Object obj=joinPoint.proceed();
		long t2=System.nanoTime();
		Signature s=joinPoint.getSignature();
	//	System.out.println("时间:"+System.currentTimeMillis()+"执行了"+s+"方法，耗时："+(t2-t1));
		return obj;
	}
	public static void main(String[] args) throws FileNotFoundException{
		File file=new File("/home/soft01/the_end/last_1/wgt_note.log");
		PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
		out.println("woshi ");
		out.close();
	}
	
	
	/*@After("bean(userService)")
	public void test2(){
		System.out.println("userService执行后");
	}*/
}
