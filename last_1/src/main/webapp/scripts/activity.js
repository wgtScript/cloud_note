$(function() {
	changeTime();
	
	$('#action_part').find('div.wgt').on('click','a',detail);
	changPanel();
});

function changeTime() {
//	console.log('changeTime');
	$('#col_0 p').addClass('title');
	var time = $('.tim');
	var t = null;
	var d =null;
	for (var i = 0; i < time.length; i++) {
		t = parseInt(time[i].innerHTML);
		t = time[i];
		if (t.innerHTML != "") {
			d = new Date(parseInt(t.innerHTML));
		}else{
			d = new Date();
		}
		t.innerHTML = d.getFullYear() + '-' + d.getMonth() + '-'
		+ d.getDate();
	}
}

function detail(){
	console.log('detail@@@');
	var t=$(this).parent().next().val();
	console.log(t);
	location.href='detail.do?id='+t;
}

function changPanel(){
	$('.wgt').each(function(index,domEle){
		if(index%4==0){
			
		}
		if(index%4==1){
			$(domEle).addClass('bg-danger');
		}
		if(index%4==2){
			$(domEle).addClass('bg-inverse');
		}
		if(index%4==3){
			$(domEle).addClass('bg-warning');
		}
	})
}




























