$(function(){
	$('#rollback_button').click(loadDeleteNote);
	
});

function loadDeleteNote(){
	$('#pc_part_2').hide();
	$('#pc_part_7').hide();
	
	$('#pc_part_4').show();
	$('#pc_part_8').hide();
	var userId=getCookie('userId');
	$.getJSON('loadDeleteNote.do',{start:0,userId:userId},function(result){
		model.deleteNotes=result.data;
		model.updateDeleteNotes();
		$('#pc_part_4 .contacts-list').on('click','button.btn_delete',loadConfirmDelete);
		$('#pc_part_4 .contacts-list').on('click','button.btn_replay',loadReplay);
	});
}
function loadConfirmDelete(){
	model.deleteNoteIndex=$(this).parent().parent().index();
	var noteId=model.deleteNotes[model.deleteNoteIndex].noteId;
	
	console.log('confirm');
	$('#can').load('alert/alert_delete_rollback.html',function(){
		closeDial();
		$('#can').find('button.sure').click(function(){
			console.log('即将删除');
			$.post('sureDeleteNote.do',{noteId:noteId},function(result){
				if(result.state==SUCCESS){
					console.log('真的删掉了哟？');
					model.deleteNotes.splice(model.deleteNoteIndex,1);
					closeDialog();
					model.updateDeleteNotes();
	
				}
			}); 
		});
	});
	$('.opacity_bg').show();
}
model.updateDeleteNotes=function(){
	
	var oUl=$('#pc_part_4 .contacts-list').empty();
	console.log('hahhaha');
	var ul="";
	var template='<li class="disable"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> [deleteNote.title]'+
		'<button type="button" class="btn btn-default btn-xs btn_position btn_delete" title="彻底删除"><i class="fa fa-times"></i>'+
	'</button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay" title="撤销"><i class="fa fa-reply"></i></button></a></li>';
	for(var i=0;i<model.deleteNotes.length;i++){
		var obj=model.deleteNotes[i];
		var li=template.replace('[deleteNote.title]',obj.title);
		ul+=li;
	};
	oUl.append(ul);
}

function loadReplay(){
	model.deleteNoteIndex=$(this).parent().parent().index();
	var noteId=model.deleteNotes[model.deleteNoteIndex].noteId;
	console.log('replay');
	var url='toReplay.do';
	$.post(url,{noteId:noteId},function(result){
		//console.log(result.data);
		model.deleteNotes.splice(model.deleteNoteIndex,1);
		model.updateDeleteNotes();
	});
	//$('#can').load('alert/alert_replay.html');
	
}






