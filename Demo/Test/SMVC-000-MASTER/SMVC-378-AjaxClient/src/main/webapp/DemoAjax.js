$(function() {
    'use strict';
    
    //var uri="http://localhost:8080/SMVC-375-JACKSON/demo/api/v1/contacts/3/groups/1";
    var uri="http://localhost/SMVC-375-JACKSON/demo/api/v1/contacts/search/?name=stefano";
    
    var newContact= {
    		"id": 8,
    		"name": "Mock Name",
    		"telephone": "069843298332",
    		"joinDate": "27-01-2017",
    		"pictureAsUrl": "/pics/Ivan.jpg",
    		"pictureAsBytes": null,
    		"type": "Business",
    		 "department": "A Mock Department",
    		"groups": [
    		  {
    		    "id": 0,
    		    "name": "group0",
    		    "contacts": []
    		  },
    		  {
    		    "id": 1,
    		    "name": "group1",
    		    "contacts": []
    		  }]    		  
    };
    
    $('#sendGetRequest').click(function() {	
    	alert("Connection");
    	
    	$.ajax({
    		url: uri, 
    		method : 'PUT',
    		data:newContact,
    		dataType :'json',
    		contentType: 'application/json',
			success: function(result){
				alert(JSON.stringify(result));
			 },			 
			 error: function(e){
				 console.log(e);
				 alert(e);			       
			 },
			 timeout: 30000,
			 crossDomain: true
    	});
    	
    });
    
    
   
    /*
    var connectedMsg={'from':'server', 'topic':'connection','message':'connection established','time':new Date()};
    var wsocket; 
    
    function showMessage(mesg)
    {
    	$('#messages').append('<tr>' +
			      '<td>' + mesg.from + '</td>' +
			      '<td>' + mesg.group + '</td>' +
			      '<td>' + mesg.message + '</td>' +
			      '<td>' + mesg.date + '</td>' +
			      '</tr>');
    }

    function setConnected(connected) {
		$("#connect").prop("disabled", connected);
		$("#disconnect").prop("disabled", !connected);
		$('#from').prop('disabled', !connected);
		$('#group').prop('disabled', !connected);
		$('#message').prop('disabled', !connected);
		
		if (connected) {
		    $("#conversation").show();
		    $('#text').focus();
		}
		else $("#conversation").hide();
		$("#messages").html("");
	 }

    $("form").on('submit', function (e) {
    	e.preventDefault();
    });

    $('#message').on('blur change keyup', function(ev) {
    	$('#connect').prop('disabled', $(this).val().length == 0 );
    });
    
    $('#connect').prop('disabled', false);
    $('#disconnect,#text').prop('disabled', true);

    

    $('#connect').click(function() {	
    	wsocket = new WebSocket("ws://localhost:8080/SMVC-800-WebSocketJSR356/wsDemoServer");    	
    	setConnected(true);
    	
    	wsocket.onmessage = function(e) {
    		showMessage(JSON.parse(e.data));
            //console.log('message', e.data);
        };

        wsocket.onclose = function() {
            console.log('close');
        };
    });

    
    
//    $('#disconnect').click(function() {
//		if (sockJs != null) {
//			sockJs.disconnect();
//		    setConnected(false);
//		}		
//    });

    $('#send').click(function() {
    	
    	if(wsocket){
    		var msg=newMessageAsString();
    		wsocket.send(msg);  
    		$('#text').val("");
    	}else{
    		alert("Open connection first")
    	}       
    });
    
    
    function newMessageAsString(){
    
    	var date=new Date();
    	var mm=date.getMonth()+1;
    	var dateAsString= date.getDate()+"/"+mm+"/"+date.getFullYear()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    	    	
    	return JSON.stringify({
    		from: $("#from").val(),
    		group: $('#group').val(),
    		message: $('#message').val(),
    		date:dateAsString
    	});
    }
    */
    
});
