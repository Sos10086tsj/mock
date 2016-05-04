$(function(){
	Ext.require(['*']);
	 
	Ext.onReady(function () {
		Ext.QuickTips.init();
		 
		Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

        var viewport = Ext.create('Ext.Viewport', {
            id: 'border-example',
            layout: 'border',
            items: [
            mock.homepageItem.initNorthPanel(), 
            mock.homepageItem.initSouthPanel(), 
            mock.homepageItem.initEastPanel(), 
            mock.homepageItem.initWestPanel(),
            mock.homepageItem.initCenterPanel()
            ]
        });
	}); 
});