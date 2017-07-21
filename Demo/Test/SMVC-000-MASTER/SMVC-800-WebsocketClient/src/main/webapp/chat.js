$(function() {
    'use strict';

    var client;
     
    function showMessage(mesg)
    {
    	$('#messages').append('<tr>' +
			      '<td>' + mesg.from + '</td>' +
			      '<td>' + mesg.topic + '</td>' +
			      '<td>' + mesg.message + '</td>' +
			      '<td>' + mesg.time + '</td>' +
			      '</tr>');
    }

    function setConnected(connected) {
		$("#connect").prop("disabled", connected);
		$("#disconnect").prop("disabled", !connected);
		$('#from').prop('disabled', connected);
		$('#text').prop('disabled', !connected);
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
    
    $('#connect,#disconnect,#text').prop('disabled', true);

    $('#connect').click(function() {
	    var sockJs = new SockJS("http://localhost:8080/SMVC-800-WebsocketServer/chat");
		client = Stomp.over(sockJs);
		client.connect({}, function (frame) {
		    setConnected(true);		    
		    client.subscribe('/topic/messages', function (message) {
		    	showMessage(JSON.parse(message.body));
		    });
		});
    });

    $('#disconnect').click(function() {
		if (client != null) {
		    client.disconnect();
		    setConnected(false);
		}
		client = null;
    });

    $('#send').click(function() {
		var topic = $('#topic').val();
		client.send("/app/chat/" + topic, {}, JSON.stringify({
		    from: $("#from").val(),
		    text: $('#text').val(),
		}));
		$('#text').val("");
    });
});
