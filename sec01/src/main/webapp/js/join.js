 function check_ok(){
	 if (document.frm.jumin_1.value.length != 6){
		 alert("6글자 이상");
		 reg_frm.jumin_1.focus();
		 return false;
	 }
	 
	 else if (document.frm.jumin_2.value.length != 7){
		 alert("7글자 이상");
		 document.reg_frm.jumin_2.focus();
		 return false;
	 }
	 
	 else if (document.frm.id.value.length < 4){
		alert("4글자");
		ocument.reg_frm.id.focus();
		return false;
	 }
	 else if (document.frm.pwd.value != document.reg_frm.pwd_re.value){
		 alert("패스워드 확인");
		 reg_frm.pwd_re.focus();
		 return false
	 }
	 return true;
 }