 function chkPw(){
		var userpw = $('#userpw').val();
		var userpwchk = $('#userpwchk').val();
	
		$('#userpw').keyup(function(){
			$('notsame').html('');
		});
		
		$('#userpwchk').keyup(function(){
			if(userpw === userpwchk){
				$('#notsame').html('');
				$('#notsame').attr('display','none');
			} else{
				$('#notsame').html('비밀번호가 일치하지 않습니다.');
			}
		});
	}  

