mock.loginItem = {
	//登录框用户名
	initUsername : function(){
		var username = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'username',
			fieldLabel : mock.loginLabel.usernameLable,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : mock.loginLabel.usernameBlankText,
			maxLengthText : mock.loginLabel.usernameMaxLengthText,
			margin : '10 0 10 0'
		});
		return username;
	},

	//登录框密码
	initPassword : function(){
		var pass = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'password',
			fieldLabel : mock.loginLabel.passLabel,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : mock.loginLabel.passBlankText,
			inputType : 'password'
		});
		return pass;
	},
	
	//登陆按钮
	initLoginBtn : function(){
		var loginBtn = new Ext.Button({
			text: mock.loginLabel.loginText,
			handler: function(){
				if (mock.login.loginForm.getForm().isValid()){
					mock.login.loginForm.submit({
						url : ctx + '/login',
						method : 'POST',
						waitMsg : mock.loginLabel.waitingMsg,
						timeout : 60000,
						success : function(form, action){
							window.location.href = ctx + "/homepage";
						},
						failure : function(form, action){
							Ext.MessageBox.alert('提醒', '无法登陆！');
						}
					});
				}else{
					alert("else");
				}
			}
		});
		return loginBtn;
	}
};