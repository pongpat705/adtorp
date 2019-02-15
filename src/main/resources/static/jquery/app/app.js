$( document ).ready(function() {
    console.log( "ready!" );
    getAllFilm(0, 20, 'G')
});

function getAllFilm(page, size, rating){
	$.ajax({
	    url: '/api/allFilmsByRatingViaReposCustomNativeQueryMethod?page='+page+'&rating='+rating+'&size='+size,
	    type: "get",
	    dataType: "json",
	    
	    success: function(data, textStatus, jqXHR) {
	        // since we are using jQuery, you don't need to parse response
	    	console.log(data);
	    	var header = "<tr>" +
	    	"	<td>Title</td>" +
	    	"	<td>Description</td>" +
	    	"	<td>Release year</td>" +
	    	"</tr>";
	        drawTable(data.content, header);
	    }
	});
}

function drawTable(data, header) {
	
	$("#filmDisplay").append(header);
    for (var i = 0; i < data.length; i++) {
        drawRow(data[i]);
    }
}

function drawRow(rowData) {
    var row = $("<tr />");
    $("#filmDisplay").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
    row.append($("<td>" + rowData.title + "</td>"));
    row.append($("<td>" + rowData.description + "</td>"));
    row.append($("<td>" + rowData.releaseYear + "</td>"));
}