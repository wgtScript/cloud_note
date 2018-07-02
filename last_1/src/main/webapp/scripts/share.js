$(function(){
	console.log('share.js');
	$('#like_button').click(loadShareAction);
	
	$('#action_button').click(loadActivityNoteAction);
});
function loadShareAction(){
	$('#pc_part_2').hide();
	$('#pc_part_4').hide();
	$('#pc_part_7').show();
	$('#pc_part_8').hide();
	
	
}
function loadActivityNoteAction(){
	$('#pc_part_2').hide();
	$('#pc_part_4').hide();
	$('#pc_part_7').hide();
	$('#pc_part_8').show();
	var userId=getCookie('userId');
	$.getJSON('showUserJoinNotes.do',{userId:userId},function(result){
		console.log(result.data);
		console.log('*&**************************************');
		
		model.activityNotes=result.data;
		model.updateActivityNotes();
	})
}
model.updateActivityNotes=function(){
	var oUl=$('#activityNoteUl').empty();
	var template='<li class="offline"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note.title]</a></li>';
	var ul="";
	var li="";
	for(var i=0;i<model.activityNotes.length;i++){
		var obj=model.activityNotes[i];
		li=template.replace('[note.title]',obj.title);
		ul+=li;
	}
	oUl.append(ul);
}








