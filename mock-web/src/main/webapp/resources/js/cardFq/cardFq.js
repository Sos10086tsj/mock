mock.cardFq = {
	popUpWindow : null,
	init : function(){
		var store = mock.cardFqItem.initStore();
		
		var height = $("#js_tab_TEST3").height()
		var width = $("#js_tab_TEST3").width();
		
		var grid =Ext.create('Ext.grid.Panel', {
			width: width,
	        height: height,
	        store: store,
	        frame: true,
	        loadMask: true,
	        renderTo: 'js_cardFq_panel',
	        autoScroll : true,
	        columns: [     
	            {
	            	header: '账号',
	            	dataIndex: 'accno'
	            },
	            {
	            	header: '主卡卡号',
	            	dataIndex: 'mdcardno'
	            },
	            {
	            	header: '消费金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'amount',
	            	format: '¥0,0'
	            },
	            {
	            	header: '授权金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'authamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'feeamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '每期金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'eachamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '每期手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'eachpfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '总期数',
	            	dataIndex: 'totnum',
	            },
	            {
	            	header: '剩余期数',
	            	dataIndex: 'leftnum',
	            },
	            {
	            	header: '申请日期',
	            	dataIndex: 'workdate'
	            },
	            {
	            	header: '上期扣款',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'thisamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '上期扣款手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'thispfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '已入账',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'realamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '已入账手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'realpfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '累计违约次数',
	            	dataIndex: 'errnum',
	            },
	            {
	            	header: '连续违约次数',
	            	dataIndex: 'conernum',
	            },
	            {
	            	header: '滞纳金最后收取日期',
	            	dataIndex: 'errdate',
	            },
	            {
	            	header: '首期金额',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'firstamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '首期手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'firstpfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '原始消费日期',
	            	dataIndex: 'ortrxdate',
	            },
	            {
	            	header: '已还本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'paybamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '已还手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'paybfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '未还本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'unpaybamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '未还手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'unpaybfee',
	            	format: '¥0,0'
	            },
	            {
	            	header: '昨日授权本金',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'lstauamt',
	            	format: '¥0,0'
	            },
	            {
	            	header: '最近违约日期',
	            	dataIndex: 'conerdate'
	            },
	            {
	            	header: '已退持卡人手续费',
	            	xtype: 'numbercolumn',
	            	dataIndex: 'backfamt',
	            	format: '¥0,0'
	            }
	        ],
	        tbar : [
	            {
	            	xtype: 'combo',
		        	listConfig:{
		        		emptyText:'未找到匹配值',  
		        		loadingText: '正在查找...',
             			maxHeight:180
		        	},
		        	minChars:6,
             		queryDelay:200,
             		name:'mdcardno',
             		fieldLabel:'卡号',
             		displayField:'label',
             		valueField:'value',
             		queryMode:'remote',
             		hideTrigger: true,
             		typeAhead:true,
             		forceSelection:true,
             		store : mock.cardFqItem.mdcardnoStore(),
             		listeners:{
             			select:function(combo,record,opts) {
             				var mdcardno = record[0].get("value");
             				mock.cardFq.reload(store,mdcardno);
             			}
             		}
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
	        		mock.cardFq.showEditWindow('修改',record, store);
		        }
	        }
		});
		
		store.loadPage(1);
	},
	
	showEditWindow : function(title,record, store){
		mock.cardFq.popUpWindow = new Ext.Window({
    		title: '分期管理',
//    		width: 400,
//            height: 600,
//            autoScroll : true,
            items: [
                   mock.cardFq.showEditForm(title,record, store)
            ]
    	});
		mock.cardFq.popUpWindow.show();
	},
	
	showEditForm : function(title, record, store){
		var id = '' == record ? '' : record.get('id');
		var version = '' == record ? 0 : record.get('version');
		var bankId = '' == record ? 2 : record.get('bankId');
		var accno = '' == record ? '' : record.get('accno');
		var mdcardno = '' == record ? '' : record.get('mdcardno');
		var amount = '' == record ? 0 : record.get('amount');
		var authamt = '' == record ? 0 : record.get('authamt');
		var feeamt = '' == record ? 0 : record.get('feeamt');
		var totnum = '' == record ? 0 : record.get('totnum');
		var leftnum = '' == record ? 0 : record.get('leftnum');
		var workdate = '' == record ? new Date() : new Date(record.get('workdate'));
		var thisamt = '' == record ? 0 : record.get('thisamt');
		var thispfee = '' == record ? 0 : record.get('thispfee');
		var realamt = '' == record ? 0 : record.get('realamt');
		var realpfee = '' == record ? 0 : record.get('realpfee');
		var errnum = '' == record ? 0 : record.get('errnum');
		var conernum = '' == record ? 0 : record.get('conernum');
		var errdate = '' == record ? new Date() : new Date(record.get('errdate'));
		var firstamt = '' == record ? 0 : record.get('firstamt');
		var firstpfee = '' == record ? 0 : record.get('firstpfee');
		var ortrxdate = '' == record ? new Date() : new Date(record.get('ortrxdate'));
		var paybamt = '' == record ? 0 : record.get('paybamt');
		var paybfee = '' == record ? 0 : record.get('paybfee');
		var unpaybamt = '' == record ? 0 : record.get('paybfee');
		var unpaybfee = '' == record ? 0 : record.get('unpaybfee');
		var lstauamt = '' == record ? 0 : record.get('lstauamt');
		var conerdate = '' == record ? new Date() : new Date(record.get('conerdate'));
		var backfamt = '' == record ? 0 : record.get('backfamt');
		var eachamt = '' == record ? 0 : record.get('eachamt');
		var eachpfee = '' == record ? 0 : record.get('eachpfee');
		
		var editForm = Ext.create('Ext.form.Panel', {
		    title: title,
		    bodyPadding: 5,
		    width: 300,
            height: 600,
            autoScroll : true,
		    url: ctx + '/cardFq/update',
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
		            	value : id
		            },
		            {
		            	fieldLabel: 'version',
		            	name: 'version',
		            	hidden: true,
		            	value : version
		            },
		            {
		            	fieldLabel: '账号',
		            	name: 'accno',
		            	allowBlank: false,
		            	value : accno
		            },
		            {
		            	fieldLabel: '主卡卡号',
		            	name: 'mdcardno',
		            	allowBlank: false,
		            	value : mdcardno
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '消费金额',
		            	name: 'amount',
		            	allowBlank: false,
		            	value : amount
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '授权金额',
		            	name: 'authamt',
		            	allowBlank: false,
		            	value : authamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '手续费',
		            	name: 'feeamt',
		            	allowBlank: false,
		            	value : feeamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '每期金额',
		            	name: 'eachamt',
		            	allowBlank: false,
		            	value : eachamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '每期手续费',
		            	name: 'eachpfee',
		            	allowBlank: false,
		            	value : eachpfee
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '总期数',
		            	name: 'totnum',
		            	allowBlank: false,
		            	value : totnum
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '剩余期数',
		            	name: 'leftnum',
		            	allowBlank: false,
		            	value : leftnum
		            },
		            {
		            	fieldLabel: '最后交易日',
		            	name: 'workdate',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : workdate,
		            	maxValue: new Date()
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '上期扣款',
		            	name: 'thisamt',
		            	allowBlank: false,
		            	value : thisamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '上期扣款手续费',
		            	name: 'thispfee',
		            	allowBlank: false,
		            	value : thispfee
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '已入账本金',
		            	name: 'realamt',
		            	allowBlank: false,
		            	value : realamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '已入账手续费',
		            	name: 'realpfee',
		            	allowBlank: false,
		            	value : realpfee
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '累计违约次数',
		            	name: 'errnum',
		            	allowBlank: false,
		            	value : errnum
		            },
		            {
		            	xtype : 'numberfield',
		            	allowDecimals:false,
		            	fieldLabel: '连续违约次数',
		            	name: 'conernum',
		            	allowBlank: false,
		            	value : conernum
		            },
		            {
		            	fieldLabel: '滞纳金最后收取日期',
		            	name: 'errdate',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : errdate,
		            	maxValue: new Date()
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '首期金额',
		            	name: 'firstamt',
		            	allowBlank: false,
		            	value : firstamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '首期手续费',
		            	name: 'firstpfee',
		            	allowBlank: false,
		            	value : firstpfee
		            },
		            {
		            	fieldLabel: '原始消费日期',
		            	name: 'ortrxdate',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : ortrxdate,
		            	maxValue: new Date()
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '已还本金',
		            	name: 'paybamt',
		            	allowBlank: false,
		            	value : paybamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '已还手续费',
		            	name: 'paybfee',
		            	allowBlank: false,
		            	value : paybfee
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '未还本金',
		            	name: 'unpaybamt',
		            	allowBlank: false,
		            	value : unpaybamt
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '未还手续费',
		            	name: 'unpaybfee',
		            	allowBlank: false,
		            	value : unpaybfee
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '昨日授权本金',
		            	name: 'lstauamt',
		            	allowBlank: false,
		            	value : lstauamt
		            },
		            {
		            	fieldLabel: '最近违约日期',
		            	name: 'conerdate',
		            	allowBlank: false,
		            	xtype: 'datefield',
		            	format : 'Y-m-d',
		            	value : conerdate,
		            	maxValue: new Date()
		            },
		            {
		            	xtype : 'numberfield',
		            	fieldLabel: '已退持卡人手续费',
		            	name: 'backfamt',
		            	allowBlank: false,
		            	value : backfamt
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
		        handler: function() {
		            var form = this.up('form').getForm();
		            if (form.isValid()) {
		                form.submit({
		                    success: function(form, action) {
		                       mock.warningResult("提示","保存成功！");
		                       mock.cardFq.popUpWindow.close();
		                       store.reload();
		                    },
		                    failure: function(form, action) {
		                        mock.warningResult("提示","保存失败！");
		                    }
		                });
		            }
		        }
		    }]
		});
		return editForm;
	},
	
	reload : function(store, mdcardno){
		var url = ctx + '/cardFq/store?mdcardno=' + mdcardno;
		store.proxy.url = url;
		store.reload();
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
		mock.cardFq.init();
	}); 
});