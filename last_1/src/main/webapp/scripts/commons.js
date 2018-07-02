var SUCCESS=1;
var ERROR=0;

var model={
	
};

function closeDial(){
	$('#can').find('button.close,.cancle').click(closeDialog);
}
function closeDialog(){
	$('#can').empty();
	$('.opacity_bg').hide();
}
