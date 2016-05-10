mock.card = {
	init : function(){
		var store = mock.cardItem.initStore();
		Ext.create('Ext.grid.Panel', {
//			width: 700,
//	        height: 500,
	        title: '卡片信息管理',
	        store: store,
	        frame: true,
	        loadMask: true,
	        renderTo: 'js_card_panel',
	        columns: [
	            {
	            	header: '账号',
	            	dataIndex: 'accno',
	            	editor: {
	            		allowBlank: false
	            	}
	            },
	            {
	            	header: '主卡卡号',
	            	dataIndex: 'accno',
	            	editor: {
	            		allowBlank: false
	            	}
	            },
	            {
	            	header: '客户编号',
	            	dataIndex: 'cino',
	            	editor: {
	            		allowBlank: false
	            	}
	            },
	            {
	            	header: '帐户本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstpbal',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '昨日余额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstbal',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '帐单应还款金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'acpayamt',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '昨日最优还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'dtopamt',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '最低还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'letpaamt',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '表内利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstiint',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '表外利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstoint',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '表外滞纳金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstlfee',
	            	format: '¥0,0',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '滞纳金连续收取次数',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lfeegno',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'numberfield',
	            		value : 0
	            	}
	            },
	            {
	            	header: '最后客户交易日',
	            	xtype: 'datecolumn',
	            	dataIndex: 'lsttrand',
	            	format: 'yyyy-MM-dd',
	            	editor: {
	            		allowBlank: false,
	            		xtype: 'datecolumn'
	            	}
	            }
	        ],
	        bbar: Ext.create('Ext.PagingToolbar', {
	            store: store,
	            displayInfo: true,
	            displayMsg: 'Displaying topics {0} - {1} of {2}',
	            emptyMsg: "No topics to display"
	        })
		});
		
		store.loadPage(1);
	}	
};

$(function(){
	Ext.require(["*"]);
	
	Ext.onReady(function () {
		Ext.QuickTips.init();
		mock.card.init();
	}); 
});