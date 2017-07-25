$(function() {
    'use strict';
    
       
    var connectedMsg={'from':'server', 'group':'connection','message':'connection established','date':''};
   // var defaultMsg={'from':'user', 'group':'testGroup','message':'a test Message','date':''};
    var stompEndpointUri="http://localhost:8080/SMVC-800-WebSocketSpringStomp/stompEndpoint";
    var stompBrokerPrefix="/broker";
    var serviceDestinationPrefix="/service";
    
    var client;
    
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
    	
    	var sockJs = new SockJS(stompEndpointUri);
 		client = Stomp.over(sockJs);
 		client.connect({}, function (frame) {
 		   setConnected(true);	 		   
 		   connectedMsg.date=nowAsString();
 		   showMessage(connectedMsg)
 		}); 
    });

	  $('#disconnect').click(function() {
		if (client != null) {
		    client.disconnect();
		    setConnected(false);
		}else{
			alert("Open connection first");
		}
		client = null;
	});
	  
    
    $('#subscribe').click(function() {
    	if(client){    		
    		var destination=$('#subscribeTo').val();
        	client.subscribe(stompBrokerPrefix+"/"+destination, function (message) {
    	    	showMessage(JSON.parse(message.body));
    	    });
    	}else{
    		alert("Open connection first");
    	}    	
    });
    
    $('#unsubscribe').click(function() {
    	if(client){    		
        	client.unsubscribe(stompBrokerDestination, function (message) {
    	    	showMessage(JSON.parse(message.body));
    	    });
    	}else{
    		alert("Open connection first");
    	}    	
    });
    
    

        
    $('#send').click(function() {	    	
    	var serviceApiUri=$('#serviceApi').val();    	  	
		client.send(serviceDestinationPrefix+"/" + serviceApiUri, {}, newMessageAsString());		
    });
    
    
    
    function newMessageAsString(){     	    	
    	return JSON.stringify({
    		from: $("#from").val(),
    		group: $('#group').val(),
    		message: $('#message').val(),
    		date:nowAsString()
    	});
    }
    
    function nowAsString(){
    	var date=new Date();
    	var mm=date.getMonth()+1;
    	return date.getDate()+"/"+mm+"/"+date.getFullYear()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    }
    
});
