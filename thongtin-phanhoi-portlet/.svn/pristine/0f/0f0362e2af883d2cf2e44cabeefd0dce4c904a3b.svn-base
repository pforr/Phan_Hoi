AUI.add(
	'liferay-dataitem',
	function(A) {
		var Dataitems = {
			getProvinces: function(callback) {
				Liferay.Service(
					'/ns-me-portlet.dataitem/get-by-data-group-level1',
					{
						active: true
					},
					callback
				);
			},

			getDistricts: function(callback, selectKey) {
				Liferay.Service(
					'/ns-me-portlet.dataitem/get-by-data-group-level2',
					{
						provinceId: Number(selectKey),
						active: true
					},
					callback
				);
			},
			
			getCommunes: function(callback, selectKey, selectKey2) {
				Liferay.Service(
					'/ns-me-portlet.dataitem/get-by-data-group-level3',
					{
						provinceId: Number(selectKey),
						districtId: Number(selectKey2),
						active: true
					},
					callback
				);
			}
		};

		Liferay.Dataitems  = {
			Dataitems: Dataitems
		};
	}
);