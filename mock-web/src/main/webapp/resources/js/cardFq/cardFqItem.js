mock.cardFqItem = {
	//store
	initStore : function(){
		var cardModel = Ext.define('CardModel', {
		    extend: 'Ext.data.Model',
		    fields: [
		        'version',
		        'id',
		        'mdcardno',
		        'accno',
		        'amount',// 消费金额 4418200
		        'authamt',// 授权金额 3626100
		        'feeamt',// 持卡人手续费 
		        'eachamt',// 每期金额
		        'totnum',// 总期数
		        {
		        	name: 'workdate', type: 'date', dateFormat: 'Y-m-d',convert: function(v,record){
		        		return mock.date.parse(v);
		        	} 
		        },//申请日期 2014-09-09
		        'thisamt',// 上期扣款金额 
		        'realamt',//已入账金额 1105300
		        'errnum',//// 累计违约次数 003
		        {
		        	name: 'errdate', type: 'date', dateFormat: 'Y-m-d',convert: function(v,record){
		        		return mock.date.parse(v);
		        	} 
		        },//滞纳金最后收取日期 2015-05-25
		        'thispfee',// 上期扣款手续费
		        'realpfee',//已入账手续费 106087
		        'firstamt',//首期金额 123700
		        {
		        	name: 'ortrxdate', type: 'date', dateFormat: 'Y-m-d',convert: function(v,record){
		        		return mock.date.parse(v);
		        	} 
		        },// 原消费日期 2014-09-05
		        'eachpfee', //每期手续费 11600
		        'firstpfee',//首期手续费 13287
		        'leftnum',// 剩余期数 027
		        'paybamt',// 分期付款已还款本金 974249
		        'paybfee',// 分期付款已还款手续费 106087
		        'unpaybamt',// 分期付款未还款本金 131051
		        'unpaybfee',// 分期付款未还款手续费 0
		        'lstauamt',//昨日授权本金 3,435,600.00
		        'conernum',// 连续违约次数 002
		        {
		        	name: 'conerdate', type: 'date', dateFormat: 'Y-m-d',convert: function(v,record){
		        		return mock.date.parse(v);
		        	} 
		        },// 上次违约日期 2015-05-25
		        'backfamt' // 已退持卡人手续费 0.00
		    ]
		});
		
		var cardStore = Ext.create('Ext.data.Store', {
			pageSize: 50,
			model : cardModel,
			proxy : {
				type: 'ajax',
				url : ctx + '/cardFq/store?mdcardno=' + $("#js_hidden_mdcardno").val(),
				method : 'get',
				reader: {
		             type: 'json',
		             root : 'data',
		             totalProperty: 'total'
		         }
			},
			autoLoad : false
		});
		
		return cardStore;
	},
	
	mdcardnoStore : function(){
		var model = Ext.define('MdcardnoModel', {
	        extend: 'Ext.data.Model',
	        fields: [
	            'value',
	            'label'
	        ]
		});
		
		var store = Ext.create('Ext.data.Store',{
			model: model,
			proxy : {
				type: 'ajax',
				url : ctx + '/cardFq/mdcardno/',
				method : 'get',
				reader: {
		             type: 'json',
		             root : ''
		         }
			},
			autoLoad : false
		});
		return store;
	}
}