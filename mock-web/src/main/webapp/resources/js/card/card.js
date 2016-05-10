mock.card = {
	init : function(){
		var store = mock.cardItem.initStore();
		var grid =Ext.create('Ext.grid.Panel', {
//			width: 700,
//	        height: 500,
	        title: '卡片信息管理',
	        store: store,
	        frame: true,
	        loadMask: true,
	        renderTo: 'js_card_panel',
	        columns: [
	             {
	            	 header: 'ID#',
	            	 dataIndex: 'id',
	            	 hidden : true
	            },
	            {
	            	header: '账号',
	            	dataIndex: 'accno'
	            },
	            {
	            	header: '主卡卡号',
	            	dataIndex: 'accno'
	            },
	            {
	            	header: '客户编号',
	            	dataIndex: 'cino'
	            },
	            {
	            	header: '帐户本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstpbal',
	            	format: '¥0,0'
	            },
	            {
	            	header: '昨日余额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstbal',
	            	format: '¥0,0'
	            },
	            {
	            	header: '帐单应还款金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'acpayamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '昨日最优还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'dtopamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '最低还款额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'letpaamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表内利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstiint',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表外利息',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstoint',
	            	format: '¥0,0'
	            },
	            {
	            	header: '表外滞纳金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstlfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '滞纳金连续收取次数',
	            	dataIndex: 'lfeegno'
	            },
	            {
	            	header: '最后客户交易日',
	            	dataIndex: 'lsttrand'
	            }
	        ],
	        bbar: Ext.create('Ext.PagingToolbar', {
	            store: store,
	            displayInfo: true,
	            displayMsg: 'Displaying topics {0} - {1} of {2}',
	            emptyMsg: "No topics to display"
	        }),
	        listeners : {
	        	itemdblclick: function(tablepanel, record, item, index, e, options){
		        	var editWindow = new Ext.Window({
		        		title: '卡片管理',
//		        		width: 600,
//                        minHeight: 400,
                        items: [
                               mock.card.showEditForm('修改',record)
                        ]
		        	});
		        	editWindow.show();
		        }
	        }
		});
		
		store.loadPage(1);
	},
	
	showEditForm : function(title, record){
		var editForm = Ext.create('Ext.form.Panel', {
		    title: title,
		    bodyPadding: 5,
		    url: ctx + '/card/update',
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },
		    defaultType: 'textfield',
		    items: [
		            {
		            	fieldLabel: 'ID',
		            	name: 'id',
		            	hidden: true,
		            	value : record.get('id')
		            },
		            {
		            	fieldLabel: 'BankId',
		            	name: 'bankId',
		            	hidden: true,
		            	value : record.get('bankId')
		            },
		            {
		            	fieldLabel: 'BANK_ID',
		            	name: 'bankId',
		            	hidden: true,
		            	value : record.get('bankId')
		            },
		            {
		            	fieldLabel: '账号',
		            	name: 'accno',
		            	allowBlank: false,
		            	value : record.get('accno')
		            },
		            {
		            	fieldLabel: '主卡卡号',
		            	name: 'mdcardno',
		            	allowBlank: false,
		            	value : record.get('mdcardno')
		            },
		            {
		            	fieldLabel: '客户编号',
		            	name: 'cino',
		            	allowBlank: false,
		            	value : record.get('cino')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '帐户本金',
		            	name: 'lstpbal',
		            	allowBlank: false,
		            	value : record.get('lstpbal')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '昨日余额',
		            	name: 'lstbal',
		            	allowBlank: false,
		            	value : record.get('lstbal')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '帐单应还款金额',
		            	name: 'acpayamt',
		            	allowBlank: false,
		            	value : record.get('acpayamt')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '昨日最优还款额',
		            	name: 'dtopamt',
		            	allowBlank: false,
		            	value : record.get('acpayamt')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '最低还款额',
		            	name: 'letpaamt',
		            	allowBlank: false,
		            	value : record.get('letpaamt')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表内利息',
		            	name: 'lstiint',
		            	allowBlank: false,
		            	value : record.get('lstiint')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表外利息',
		            	name: 'lstoint',
		            	allowBlank: false,
		            	value : record.get('lstoint')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '表外滞纳金',
		            	name: 'lstlfee',
		            	allowBlank: false,
		            	value : record.get('lstlfee')
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '滞纳金连续收取次数',
		            	name: 'lfeegno',
		            	allowBlank: false,
		            	value : record.get('lfeegno')
		            },
		            {
		            	fieldLabel: '最后交易日',
		            	name: 'lsttrand',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : new Date(record.get('lsttrand'))
//		            	maxValue: new Date()
		            }
		            ],
		    buttons: [{
		        text: '重置',
		        handler: function() {
		            this.up('form').getForm().reset();
		        },
		        disabled : true
		    }, {
		        text: '提交',
//		        formBind: true,
//		        disabled: true,
		        handler: function() {
		            var form = this.up('form').getForm();
		            if (form.isValid()) {
		                form.submit({
		                    success: function(form, action) {
		                       Ext.Msg.alert('Success', action.result.msg);
		                    },
		                    failure: function(form, action) {
		                        Ext.Msg.alert('Failed', action.result.msg);
		                    }
		                });
		            }
		        }
		    }]
		});
		return editForm;
	}
};

$(function(){
	Ext.require(['Ext.grid.*',
	             'Ext.data.*',
	             'Ext.util.*',
	             'Ext.state.*',
	             'Ext.form.*',
    			 'Ext.window.MessageBox',
    			 'Ext.toolbar.Paging',
    			 'Ext.ux.PreviewPlugin',
    			 'Ext.ModelManager',
    			 'Ext.tip.QuickTipManager']);
	
	Ext.onReady(function () {
		Ext.QuickTips.init();
		mock.card.init();
	}); 
});