var joinModel={};


$(function(){
	
	loadJoinNoteAction();
	$('#join_action').click(addJoinNote);
	
});


function loadJoinNoteAction(){
	//console.log('loadJoinNoteAction()');
	var se=window.location.search;
	var id=se.replace('?id=',"");
//	console.log(id);
	joinModel.activityId=id;
	
	$.getJSON('showJoinNote.do',{id:id},function(result){
		joinModel.joinNotes=result.data;
		joinModel.loadNotes();
	});
	$('#activityUl').on('click','li',showPreview);
	
}
joinModel.loadNotes=function(){
	var template='<li class="online"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>[note.title]<button type="button" class="btn btn-default btn-xs btn_position_3 btn_up"><i class="fa fa-thumbs-o-up"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_down"><i class="fa fa-thumbs-o-down"></i></button><button type="button" class="btn btn-default btn-xs btn_position btn_like"><i class="fa fa-star-o"></i></button></a></li>';
	var li="";
	var ul="";
	var oUl=$('#activityUl').empty();
	
	for(var i=0;i<this.joinNotes.length;i++){
		var obj=this.joinNotes[i];
		li=template.replace('[note.title]',obj.title);
		ul+=li;
	}
	oUl.append(ul);
}
function showPreview(){
	
		joinModel.noteIndex=$(this).index();
		$(this).parent().find('a').removeClass('checked');
		$(this).find('a').addClass('checked');
		
		var note=joinModel.joinNotes[joinModel.noteIndex];
	//	console.log(note.body);
		
		$('#content_body').find('span').text(note.title);
		$('#content_body').find('h5')[0].innerHTML='<p style="font-size:20px"><strong>笔记内容：</strong></p>'+note.body;
};

function addJoinNote(){
	console.log('addJoinNote()');
	$('#modalBasic_15').show().on('click','button.close,.cancle',closeDialog);
	$('#modalBasic_15').on('click','button.sure',noteJoinAction);
	

	
	var userId=getCookie('userId');
	$.getJSON('showNoteBooks.do',{userId:userId},function(result){
		joinModel.books=result.data;
		joinModel.loadNoteBooks();
	});
	
	$('#booksUl').on('click','li',loadNotesAction);
	$('#notesUl').on('click','li',clickNoteAction);
	
}
function closeDialog(){
	$('#modalBasic_15').hide();
}

joinModel.loadNoteBooks=function(){
	console.log(joinModel.books);
	var template='<li class="online"><a ><i class="fa fa-book" title="online" rel="tooltip-bottom"></i>[book.name]</a></li>';
	var oBooksUl=$('#booksUl').empty();
	var ul="";
	var li="";
	for(var i=0;i<this.books.length;i++){
		var obj=this.books[i];
		li=template.replace('[book.name]',obj.name);
		ul+=li;
	}
	oBooksUl.append(ul);
}

function loadNotesAction(){
	$(this).parent().find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	joinModel.bookIndex=$(this).index();
	//console.log($(this).index());
	$.getJSON('loadNotes.do',{bookId:joinModel.books[joinModel.bookIndex].id,start:0},function(result){
		joinModel.notes=result.data;
		joinModel.updateNotes();
	});
	
}
joinModel.updateNotes=function(){
	//console.log('updateNotes');
	var oNotesUl=$('#notesUl').empty();
	var template='<li class="online"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> [note_title]</a></li>';
		var ul="";
		var li="";
		for(var i=0;i<joinModel.notes.length;i++){
			var obj=joinModel.notes[i];
		   li=template.replace('[note_title]',obj.title);
			ul+=li;
		}
		oNotesUl.append(ul);
}

function clickNoteAction(){
	joinModel.toJoinNoteIndex=$(this).index();
	$(this).parent().find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	
}

function noteJoinAction(){
//	console.log('noteJoin');
	var joinNote=joinModel.notes[joinModel.toJoinNoteIndex];
	console.log(joinNote);
	//把  这条笔记----》加入当前  活动   所以需要  活动id，笔记id，
	/*所以是insert into
	 *  cn_note_activity
	 *  	values(
	 * 
	 * */
	var activityId=joinModel.activityId;
	var noteId=joinNote.noteId;
	for(var i=0;i<joinModel.joinNotes.length;i++){
		var obj=joinModel.joinNotes[i];
		if(obj.noteId==noteId){
			console.log('笔记已经投稿，不可再投。');
			closeDialog();
			//console.log('hhahah&&&&&&&&&&&&&&&&&&&&&');
			alert('丫的，这个笔记已经投稿了');
			
			return;
		}
		
	};
	
	var body=joinNote.body;
	var title=joinNote.title;
	
	$.getJSON('addJoinNote.do',{activityId:activityId,noteId:noteId,body:body,title:title},function(result){
		//console.log('HHHHHHH');
	//	console.log(result.data);
		joinModel.joinNotes.unshift(result.data);
	//	console.log(joinModel.joinNotes);
		
		joinModel.loadNotes();
		closeDialog();
	});
	
}






























