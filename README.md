# CodigoWS
codigo de trabajo WorldSkills

select assets.AssetSN,assets.AssetName,MAX(emergencymaintenances.EMEndDate), COUNT(*) from assets INNER JOIN emergencymaintenances on assets.ID = emergencymaintenances.AssetID  GROUP BY assets.AssetSN,assets.AssetName ORDER BY emergencymaintenances.AssetID;

select assets.AssetSN,assets.AssetName,MAX(emergencymaintenances.EMEndDate), COUNT(*) from assets INNER JOIN emergencymaintenances on assets.ID = emergencymaintenances.AssetID WHERE emergencymaintenances.EMEndDate is NOT null GROUP BY assets.AssetSN,assets.AssetName ORDER BY emergencymaintenances.AssetID;
