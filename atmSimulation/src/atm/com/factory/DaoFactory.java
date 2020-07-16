package atm.com.factory;

import atm.com.Dao.AtmDao;
import atm.com.impl.atmDaoOracleImpl;

public final class DaoFactory {
	

	public static AtmDao getAtmDao(){
		return new atmDaoOracleImpl();
	}

}
