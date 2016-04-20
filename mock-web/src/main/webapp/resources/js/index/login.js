mock.login = {
	loginForm : null,
	
	initLoginPanel : function(){
		var panelWidth = 250;
		var panelHeight = 150;
		
		var height = $(window).height();
		var width = $(window).width();
		var marginLeft = (width - panelWidth) / 2;
		if(marginLeft <= 0) {
			marginLeft = 0;
		}
		var marginTop = (height - panelHeight) / 2;
		if(marginTop <= 0) {
			marginTop = 0;
		}
		
		var margin = marginTop + ' auto auto ' + marginLeft;
		
		mock.login.loginForm = Ext.create("Ext.form.Panel",{
			title : '<font style="font-size: 18px;">' + mock.loginLabel.panelTitleLabel + '</font>',
			frame : true,
			buttonAlign: 'center',
			width : panelWidth,
			minWidth : panelWidth,
			height : panelHeight,
			minHeight : panelHeight,
			renderTo : 'login_panel',
			layout : {
				type : 'vbox',
				padding : '5',
				pack : 'center',
				align : 'center'
			},
			margin : margin,
			items : [
				mock.loginItem.initUsername(),
				mock.loginItem.initPassword()
			],
			buttons : [
				mock.loginItem.initLoginBtn()
			]
		});
	}
};

$(function(){
	Ext.onReady(function () {
		Ext.QuickTips.init();
		mock.login.initLoginPanel();
	}); 
});