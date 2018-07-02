$(function(){
	
	$('#notes').on('click','button',loadNotemenu);

	
});


function loadNotemenu(){
	var noteI=$(this).parent().parent().parent().parent().index();
	model.noteId=noteI;
	console.log(noteI+'****************************');
	
	console.log('loadDia');
	$('.note_menu').hide();
	$(this).parent().next().load("alert/note_menu.jsp",function(){
		$('.btn_delete').click(loadDeleDia);
	}).toggle();
}
function loadDeleDia(){

$('#can').load("alert/alert_delete_note.html",afterShowDeleteDia);
$('.opacity_bg').show();

}

function afterShowDeleteDia(){
	$('#can').find('button.close,.cancle').click(closeDialog);
	$('#can').find('button.sure').click(removeToRollback);
}
function removeToRollback(){
	console.log('要到回收站了。。。。。。');
	var url='toRollback.do';
	$.post(url,{noteId:model.notes[model.noteId].noteId},function(result){
		//console.log(result.data);
		model.notes.splice(model.noteId,1);
		
		model.updateNotes();
	});
	closeDialog();
	console.log('进入回收站了。');
}

model.updateNotes=function(){
	//这里占个坑，没有分页，一页读20条，目前是  最多只能显示20
	var oUl=$('#notes').empty();
	var template='<li class="online"><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note_title]'+
	'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i>'+
	'</button></a><div class="note_menu" tabindex="-1" ></div></li>';
		var ul="";
		for(var i=0;i<model.notes.length;i++){
			var obj=model.notes[i];
			var li=template.replace('[note_title]',obj.title);
			ul+=li;
		}
		oUl.append(ul);
}





