<html>	<head>
	<META HTTP-EQUIv="Refresh" CONTENT="2;URL=home.jlc">
		<title>INDEX</title>
	<link rel="stylesheet" href="normalize.css">
	<link rel="stylesheet" href="style.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="modernizr.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			if(!Modernizr.meter){
				alert('Sorry your brower does not support HTML5 progress bar');
			} else {
				var progressbar = $('#progressbar'),
					max = progressbar.attr('max'),
					time = (1000/max)*5,	
			        value = progressbar.val();

			    var loading = function() {
			        value += 1;
			        var val = progressbar.val(value);
			        
			        $('.progress-value').html(value + '%');

			        if (value == max) {
			            clearInterval(animate);
			            $('.progress-value').html(max + '%');
			        }
			    };
			    var animate = setInterval(function() {
			        loading();
			    }, time);
			};
		});
	</script>
	</head>
	
	<body>
		<h1>Loading Plz Wait...</h1> <br>
		<div class="demo-wrapper html5-progress-bar">
		<div class="progress-bar-wrapper">
			<progress id="progressbar" value="0" max="100"></progress>
			<span class="progress-value">0%</span>
		</div>
	</div>
		
	</body>
	
</html>