mock.cardItem = {
	//store
	initStore : function(){
		var cardModel = Ext.define('CardModel', {
		    extend: 'Ext.data.Model',
		    fields: [
		        'bankId',
		        'version',
		        'id',
		        'accno',
		        'mdcardno',
		        'cino',
		        'lstbal',//昨日余额	-268,402.00
		        'letpaamt',//最低还款额	13,410.00
		        'lfeegno',//滞纳金连续收取次数	2
		        'dtopamt',//昨日最优还款额	134,102.00
		        'acpayamt',//帐单应还款金额	134,102.00
		        'lstpbal',//帐户本金	-265,351.00
		        'lstiint',//表内利息	-3,051.00
		        'lstoint',//表外利息	0.00
		        'lstlfee',//表外滞纳金	0.00
		        { name: 'lsttrand', type: 'date', dateFormat: 'Y-m-d',convert: function(v,record){
		        		return mock.date.parse(v);
		        	} 
		        }//最后交易日
		    ]
		});
		
		var cardStore = Ext.create('Ext.data.Store', {
			pageSize: 50,
			model : cardModel,
			proxy : {
				type: 'ajax',
				url : ctx + '/card/store',
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
				url : ctx + '/card/mdcardno/',
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