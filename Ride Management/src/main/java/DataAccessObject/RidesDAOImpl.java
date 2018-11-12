package DataAccessObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.RegistrationModel;
import model.RideModel;
import model.RideRegistrationModel;
import model.RideStates;

@Repository
@Transactional
public class RidesDAOImpl implements RidesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int RidePost(RideModel rideModel) {

		Session sess = this.sessionFactory.getCurrentSession();

		sess.persist(rideModel);

		return rideModel.getRideID();
	}

	public int updateRide(RideModel rideModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(rideModel);
		return rideModel.getRideID();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RideRegistrationModel> GetMyPostingRides(String todaysDate, String username, String searchRide) {

		Session session = this.sessionFactory.getCurrentSession();
		List<RideRegistrationModel> list = null;

		if (searchRide.equals("none")) {

			list = session.createQuery("select reg.email,rm.rideID,rm.rideTitle,"
					+ "rm.source,rm.destination,rm.rideDate, rm.phoneNumber"
					+ " from RegistrationModel reg inner join RideModel rm "
					+ "on reg.userID =rm.userID WHERE reg.email='" + username + "' and rm.isRideAvailble='" + true + "'"
					+ " and rideDate>='" + todaysDate + "'").list();
		} else {
			list = session.createQuery("select reg.email,rm.rideID,rm.rideTitle,"
					+ "rm.source,rm.destination,rm.rideDate, rm.phoneNumber"
					+ " from RegistrationModel reg inner join RideModel rm "
					+ "on reg.userID =rm.userID WHERE reg.email='" + username + "' and rm.isRideAvailble='" + true + "'"
					+ " and rideDate>='" + todaysDate + "'" + " and (reg.email like '%" + searchRide
					+ "%' or rm.rideTitle like '%" + searchRide + "%'" + " or rm.source like '%" + searchRide
					+ "%' or rm.destination like '%" + searchRide + "%')").list();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RideRegistrationModel> GetAllAvailableRides(String todaysDate, String username, String searchRide) {

		Session session = this.sessionFactory.getCurrentSession();
		List<RideRegistrationModel> list = null;

		if (searchRide.equals("none")) {

			list = session.createQuery("select reg.email,rm.rideID,rm.rideTitle,"
					+ "rm.source,rm.destination,rm.rideDate, rm.phoneNumber"
					+ " from RegistrationModel reg inner join RideModel rm "
					+ "on reg.userID =rm.userID WHERE reg.email!='" + username + "' and rm.isRideAvailble='" + true
					+ "'" + " and rideDate>='" + todaysDate + "' order by rm.rideDate").list();
		} else {
			list = session.createQuery("select reg.email,rm.rideID,rm.rideTitle,"
					+ "rm.source,rm.destination,rm.rideDate, rm.phoneNumber"
					+ " from RegistrationModel reg inner join RideModel rm "
					+ "on reg.userID =rm.userID WHERE reg.email!='" + username + "' and rm.isRideAvailble='" + true
					+ "'" + " and rideDate>='" + todaysDate + "'" + " and (reg.email like '%" + searchRide
					+ "%' or rm.rideTitle like '%" + searchRide + "%'" + " or rm.source like '%" + searchRide
					+ "%' or rm.destination like '%" + searchRide + "%') order by rm.rideDate").list();
		}

		return list;
		
	}

	public List<RideStates> getStateList() {
		Session session = this.sessionFactory.getCurrentSession();
		String SQL_QUERY = " from RideStates";
		@SuppressWarnings("unchecked")
		TypedQuery<RideStates> query = session.createQuery(SQL_QUERY);
		List<RideStates> listAvailableRides = query.getResultList();
		System.out.println(listAvailableRides);
		return listAvailableRides;
	}

	public int getUserID(String username) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// Count number of employees
			CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
			Root<RegistrationModel> root = criteriaQuery.from(RegistrationModel.class);

			criteriaQuery.select(root.get("userID"));
			criteriaQuery.where(builder.equal(root.get("email"), username));

			TypedQuery<Integer> query = session.createQuery(criteriaQuery);

			return query.getSingleResult();
		} catch (NoResultException ex) {
			return 0;
		}
	}

	public List<RideModel> getRideData(int rideIDParam) {
		Session session = this.sessionFactory.getCurrentSession();
		String SQL_QUERY = " from RideModel RM WHERE RM.rideID=?";
		@SuppressWarnings("unchecked")
		TypedQuery<RideModel> query = session.createQuery(SQL_QUERY);
		query.setParameter(0, rideIDParam);
		List<RideModel> listAvailableRides = query.getResultList();
		System.out.println(listAvailableRides);
		return listAvailableRides;
	}
}
