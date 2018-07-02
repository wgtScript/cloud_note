$(function(){
	loadEditAction();
	
	$('#notebooks').on('click','li',bookClick);

});
function loadEditAction(){
//	console.log(model);
	model.start=0;
	//console.log('loadBooks');
	loadBooks();

}

function loadBooks(start){
	if(!start){
		start=0;
	}
	var userId=getCookie('userId');
	$.getJSON('showNoteBooks.do',{userId:userId,start:start},function(result){
		var aBook=result.data;
		//console.log('*******************************');
	//	console.log(start);
		if(start==0){
			model.notebooks=aBook;
		}else{
			model.notebooks=model.notebooks.concat(aBook);
		}
	//	console.log(model.notebooks);
	//	console.log('*********************');
		var ul="";
		var template='<li class="online"><a><i class="fa fa-book" title="online" rel="tooltip-bottom"></i>[notebook_name]</a></li>';
		for(var i=0;i<aBook.length;i++){
			var obj=aBook[i];
			var li=template.replace('[notebook_name]',obj.name);
			ul+=li;
		}
		var oUl=$('.contacts-list').first();
		oUl.append(ul);
		model.start+=aBook.length;
		
		if(aBook.length>4){
			var li='<li id="show_more"><a href="javascript:showMore()" >more</a></li>';
			/*var li='<li id="show_more"><a href="javascript:showMore()" onmouseover="showMore()">more</a></li>';*/
			oUl.append(li);
		}
		
	});
}
function showMore(){
	//console.log('showMore()');
	var oUl=$('.contacts-list').first();
	oUl.find('li').last().empty();
	loadBooks(model.start);
	
	
}

function bookClick(){
	$('#pc_part_2').show();
	$('#pc_part_7').hide();
	$('#pc_part_4').hide();
	$('#pc_part_8').hide();
//	console.log('you clickBook!!!');
	$('#notebooks').find('a').removeClass('checked');
	$(this).find('a').addClass('checked');
	model.notebookIndex=$(this).index();
	showNotes();
}


function showNotes(){
	var bookId=model.notebooks[model.notebookIndex].id;
	//这里占个坑，没有分页，一页读20条，目前是  最多只能显示20
	$.getJSON('loadNotes.do',{bookId:bookId,start:0},function(result){
		model.notes=result.data;
		model.updateNotes();
	});
}




