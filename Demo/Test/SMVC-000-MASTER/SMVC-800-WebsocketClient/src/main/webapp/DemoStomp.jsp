<!DOCTYPE html>
<html>
  <head>
    <title>WebSocket Chat</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">    
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.1.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <link href="main.css" rel="stylesheet">
    <script src="chat.js"></script>
  </head>
<body>
  <div id="main-content" class="container">
    <div class="row">
      <div class="col-md-12 space-bottom10">
        <form class="form-inline">
          <div class="form-group">
            <label for="from">Name?</label>
            <input type="text" id="from" class="form-control"
		   placeholder="enter your name...">
          </div>
          <button id="connect"
		  class="btn btn-default"
		  type="submit">Connect</button>
          <button id="disconnect"
		  class="btn btn-default"
		  type="submit"
		  disabled="disabled">Disconnect</button>
	</form>
      </div>
    </div>
    <div class="row space-bottom10">
      <form>
	<div class="col-md-2">
	  <select name="topic"
		  id="topic"
		  class="form-control">
	    <option>Lifestyle</option>
	    <option>Travel</option>
	    <option>Career</option>
	  </select>
	</div>
	<div class="col-md-6">
	  <input type="text"
		 id="text"
		 class="form-control"
		 placeholder="enter message ...">
	</div>
	<div class="col-md-4">
          <button id="send"
		  class="btn btn-default"
		  type="submit">Send</button>
	</div>
      </form>
    </div>
    <div class="row">
      <div class="col-md-12">
        <table id="conversation" class="table table-striped">
          <thead>
            <tr>
	      <th width="10%">From</th>
              <th width="15%">Topic</th>
	      <th width="60%">Message</th>
	      <th width="10%">Time</th>
            </tr>
          </thead>
          <tbody id="messages">
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>
