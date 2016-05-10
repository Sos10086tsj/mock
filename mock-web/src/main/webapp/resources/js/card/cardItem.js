mock.cardItem = {
	//store
	initStore : function(){
		var cardModel = Ext.define('CardModel', {
		    extend: 'Ext.data.Model',
		    fields: [
		        {name: 'accno'},
		        {name: 'mdcardno'},
		        {name: 'cino'},
		        {name: 'lstbal'},//昨日余额	-268,402.00
		        {name: 'lstbal'},//最后客户交易日	2015-06-09
		        {name: 'letpaamt'},//最低还款额	13,410.00
		        {name: 'lfeegno'},//滞纳金连续收取次数	2
		        {name: 'dtopamt'},//昨日最优还款额	134,102.00
		        {name: 'acpayamt'},//帐单应还款金额	134,102.00
		        {name: 'lstpbal'},//帐户本金	-265,351.00
		        {name: 'lstiint'},//表内利息	-3,051.00
		        {name: 'lstoint'},//表外利息	0.00
		        {name: 'lstlfee'},//表外滞纳金	0.00
		        {name: 'lsttrand'}//最后交易日
		    ]
		});
		
		var cardStore = Ext.create('Ext.data.Store', {
			pageSize: 50,
			model : cardModel,
//			remoteSort: true,
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
	}
}