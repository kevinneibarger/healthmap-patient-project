/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.patient.registration.service.persistence;

import com.liferay.patient.registration.NoSuchistrationException;
import com.liferay.patient.registration.model.PatientRegistration;
import com.liferay.patient.registration.model.impl.PatientRegistrationImpl;
import com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the patient registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kneibarger
 * @see PatientRegistrationPersistence
 * @see PatientRegistrationUtil
 * @generated
 */
public class PatientRegistrationPersistenceImpl extends BasePersistenceImpl<PatientRegistration>
	implements PatientRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PatientRegistrationUtil} to access the patient registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PatientRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PatientRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the patient registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(uuid, patientRegistration.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where uuid = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByUuid_PrevAndNext(
		long patientRegistrationId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, patientRegistration,
					uuid, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByUuid_PrevAndNext(session, patientRegistration,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByUuid_PrevAndNext(Session session,
		PatientRegistration patientRegistration, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PatientRegistration patientRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "patientRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "patientRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(patientRegistration.uuid IS NULL OR patientRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PatientRegistrationModelImpl.UUID_COLUMN_BITMASK |
			PatientRegistrationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the patient registration where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByUUID_G(String uuid, long groupId)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByUUID_G(uuid, groupId);

		if (patientRegistration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchistrationException(msg.toString());
		}

		return patientRegistration;
	}

	/**
	 * Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the patient registration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PatientRegistration) {
			PatientRegistration patientRegistration = (PatientRegistration)result;

			if (!Validator.equals(uuid, patientRegistration.getUuid()) ||
					(groupId != patientRegistration.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<PatientRegistration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PatientRegistration patientRegistration = list.get(0);

					result = patientRegistration;

					cacheResult(patientRegistration);

					if ((patientRegistration.getUuid() == null) ||
							!patientRegistration.getUuid().equals(uuid) ||
							(patientRegistration.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, patientRegistration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PatientRegistration)result;
		}
	}

	/**
	 * Removes the patient registration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the patient registration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration removeByUUID_G(String uuid, long groupId)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByUUID_G(uuid, groupId);

		return remove(patientRegistration);
	}

	/**
	 * Returns the number of patient registrations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "patientRegistration.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "patientRegistration.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(patientRegistration.uuid IS NULL OR patientRegistration.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "patientRegistration.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PatientRegistrationModelImpl.UUID_COLUMN_BITMASK |
			PatientRegistrationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the patient registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(uuid, patientRegistration.getUuid()) ||
						(companyId != patientRegistration.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByUuid_C_PrevAndNext(
		long patientRegistrationId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, patientRegistration,
					uuid, companyId, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByUuid_C_PrevAndNext(session, patientRegistration,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByUuid_C_PrevAndNext(Session session,
		PatientRegistration patientRegistration, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PatientRegistration patientRegistration : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "patientRegistration.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "patientRegistration.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(patientRegistration.uuid IS NULL OR patientRegistration.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "patientRegistration.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PatientRegistrationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the patient registrations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if ((groupId != patientRegistration.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByGroupId_First(groupId,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where groupId = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByGroupId_PrevAndNext(
		long patientRegistrationId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, patientRegistration,
					groupId, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByGroupId_PrevAndNext(session, patientRegistration,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByGroupId_PrevAndNext(Session session,
		PatientRegistration patientRegistration, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (PatientRegistration patientRegistration : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "patientRegistration.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstName",
			new String[] { String.class.getName() },
			PatientRegistrationModelImpl.FIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAME = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the patient registrations where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstName(String firstName)
		throws SystemException {
		return findByFirstName(firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the patient registrations where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstName(String firstName,
		int start, int end) throws SystemException {
		return findByFirstName(firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstName(String firstName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAME;
			finderArgs = new Object[] { firstName, start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(firstName,
							patientRegistration.getFirstName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstName_First(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstName_First(firstName,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstName_First(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByFirstName(firstName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstName_Last(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstName_Last(firstName,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstName_Last(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFirstName(firstName);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByFirstName(firstName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByFirstName_PrevAndNext(
		long patientRegistrationId, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByFirstName_PrevAndNext(session, patientRegistration,
					firstName, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByFirstName_PrevAndNext(session, patientRegistration,
					firstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByFirstName_PrevAndNext(Session session,
		PatientRegistration patientRegistration, String firstName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstName(String firstName) throws SystemException {
		for (PatientRegistration patientRegistration : findByFirstName(
				firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstName(String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAME;

		Object[] finderArgs = new Object[] { firstName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_1 = "patientRegistration.firstName IS NULL";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 = "patientRegistration.firstName = ?";
	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 = "(patientRegistration.firstName IS NULL OR patientRegistration.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELASTNAME =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstNameLastName",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAME =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFirstNameLastName",
			new String[] { String.class.getName(), String.class.getName() },
			PatientRegistrationModelImpl.FIRSTNAME_COLUMN_BITMASK |
			PatientRegistrationModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAME = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFirstNameLastName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the patient registrations where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastName(String firstName,
		String lastName) throws SystemException {
		return findByFirstNameLastName(firstName, lastName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastName(String firstName,
		String lastName, int start, int end) throws SystemException {
		return findByFirstNameLastName(firstName, lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where firstName = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastName(String firstName,
		String lastName, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAME;
			finderArgs = new Object[] { firstName, lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELASTNAME;
			finderArgs = new Object[] {
					firstName, lastName,
					
					start, end, orderByComparator
				};
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(firstName,
							patientRegistration.getFirstName()) ||
						!Validator.equals(lastName,
							patientRegistration.getLastName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameLastName_First(String firstName,
		String lastName, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameLastName_First(firstName,
				lastName, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameLastName_First(
		String firstName, String lastName, OrderByComparator orderByComparator)
		throws SystemException {
		List<PatientRegistration> list = findByFirstNameLastName(firstName,
				lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameLastName_Last(String firstName,
		String lastName, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameLastName_Last(firstName,
				lastName, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameLastName_Last(String firstName,
		String lastName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFirstNameLastName(firstName, lastName);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByFirstNameLastName(firstName,
				lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and lastName = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByFirstNameLastName_PrevAndNext(
		long patientRegistrationId, String firstName, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByFirstNameLastName_PrevAndNext(session,
					patientRegistration, firstName, lastName,
					orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByFirstNameLastName_PrevAndNext(session,
					patientRegistration, firstName, lastName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByFirstNameLastName_PrevAndNext(
		Session session, PatientRegistration patientRegistration,
		String firstName, String lastName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_2);
		}

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where firstName = &#63; and lastName = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstNameLastName(String firstName, String lastName)
		throws SystemException {
		for (PatientRegistration patientRegistration : findByFirstNameLastName(
				firstName, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where firstName = &#63; and lastName = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstNameLastName(String firstName, String lastName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAME;

		Object[] finderArgs = new Object[] { firstName, lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_1 = "patientRegistration.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_2 = "patientRegistration.firstName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_FIRSTNAME_3 = "(patientRegistration.firstName IS NULL OR patientRegistration.firstName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_1 = "patientRegistration.lastName IS NULL";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_2 = "patientRegistration.lastName = ?";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAME_LASTNAME_3 = "(patientRegistration.lastName IS NULL OR patientRegistration.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] { String.class.getName() },
			PatientRegistrationModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the patient registrations where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastName(String lastName)
		throws SystemException {
		return findByLastName(lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the patient registrations where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastName(String lastName, int start,
		int end) throws SystemException {
		return findByLastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastName(String lastName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName, start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(lastName,
							patientRegistration.getLastName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByLastName_First(String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByLastName_First(lastName,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByLastName_First(String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByLastName(lastName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByLastName_Last(String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByLastName_Last(lastName,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByLastName_Last(String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByLastName(lastName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where lastName = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByLastName_PrevAndNext(
		long patientRegistrationId, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByLastName_PrevAndNext(session, patientRegistration,
					lastName, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByLastName_PrevAndNext(session, patientRegistration,
					lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByLastName_PrevAndNext(Session session,
		PatientRegistration patientRegistration, String lastName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLastName(String lastName) throws SystemException {
		for (PatientRegistration patientRegistration : findByLastName(
				lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLastName(String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAME;

		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_1 = "patientRegistration.lastName IS NULL";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 = "patientRegistration.lastName = ?";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 = "(patientRegistration.lastName IS NULL OR patientRegistration.lastName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PATIENTID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPatientId", new String[] { Long.class.getName() },
			PatientRegistrationModelImpl.PATIENTREGISTRATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PATIENTID = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatientId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the patient registration where patientRegistrationId = &#63; or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	 *
	 * @param patientRegistrationId the patient registration ID
	 * @return the matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByPatientId(long patientRegistrationId)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByPatientId(patientRegistrationId);

		if (patientRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("patientRegistrationId=");
			msg.append(patientRegistrationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchistrationException(msg.toString());
		}

		return patientRegistration;
	}

	/**
	 * Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param patientRegistrationId the patient registration ID
	 * @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByPatientId(long patientRegistrationId)
		throws SystemException {
		return fetchByPatientId(patientRegistrationId, true);
	}

	/**
	 * Returns the patient registration where patientRegistrationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param patientRegistrationId the patient registration ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByPatientId(long patientRegistrationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { patientRegistrationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PATIENTID,
					finderArgs, this);
		}

		if (result instanceof PatientRegistration) {
			PatientRegistration patientRegistration = (PatientRegistration)result;

			if ((patientRegistrationId != patientRegistration.getPatientRegistrationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PATIENTID_PATIENTREGISTRATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(patientRegistrationId);

				List<PatientRegistration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PATIENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PatientRegistrationPersistenceImpl.fetchByPatientId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PatientRegistration patientRegistration = list.get(0);

					result = patientRegistration;

					cacheResult(patientRegistration);

					if ((patientRegistration.getPatientRegistrationId() != patientRegistrationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PATIENTID,
							finderArgs, patientRegistration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PATIENTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PatientRegistration)result;
		}
	}

	/**
	 * Removes the patient registration where patientRegistrationId = &#63; from the database.
	 *
	 * @param patientRegistrationId the patient registration ID
	 * @return the patient registration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration removeByPatientId(long patientRegistrationId)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPatientId(patientRegistrationId);

		return remove(patientRegistration);
	}

	/**
	 * Returns the number of patient registrations where patientRegistrationId = &#63;.
	 *
	 * @param patientRegistrationId the patient registration ID
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPatientId(long patientRegistrationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PATIENTID;

		Object[] finderArgs = new Object[] { patientRegistrationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PATIENTID_PATIENTREGISTRATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(patientRegistrationId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PATIENTID_PATIENTREGISTRATIONID_2 =
		"patientRegistration.patientRegistrationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFirstNameLastNameOptIn",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFirstNameLastNameOptIn",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			PatientRegistrationModelImpl.FIRSTNAME_COLUMN_BITMASK |
			PatientRegistrationModelImpl.LASTNAME_COLUMN_BITMASK |
			PatientRegistrationModelImpl.OPTIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAMEOPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFirstNameLastNameOptIn",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastNameOptIn(
		String firstName, String lastName, int optIn) throws SystemException {
		return findByFirstNameLastNameOptIn(firstName, lastName, optIn,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastNameOptIn(
		String firstName, String lastName, int optIn, int start, int end)
		throws SystemException {
		return findByFirstNameLastNameOptIn(firstName, lastName, optIn, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameLastNameOptIn(
		String firstName, String lastName, int optIn, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN;
			finderArgs = new Object[] { firstName, lastName, optIn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN;
			finderArgs = new Object[] {
					firstName, lastName, optIn,
					
					start, end, orderByComparator
				};
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(firstName,
							patientRegistration.getFirstName()) ||
						!Validator.equals(lastName,
							patientRegistration.getLastName()) ||
						(optIn != patientRegistration.getOptIn())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_OPTIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(optIn);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameLastNameOptIn_First(
		String firstName, String lastName, int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameLastNameOptIn_First(firstName,
				lastName, optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameLastNameOptIn_First(
		String firstName, String lastName, int optIn,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByFirstNameLastNameOptIn(firstName,
				lastName, optIn, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameLastNameOptIn_Last(
		String firstName, String lastName, int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameLastNameOptIn_Last(firstName,
				lastName, optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameLastNameOptIn_Last(
		String firstName, String lastName, int optIn,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFirstNameLastNameOptIn(firstName, lastName, optIn);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByFirstNameLastNameOptIn(firstName,
				lastName, optIn, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByFirstNameLastNameOptIn_PrevAndNext(
		long patientRegistrationId, String firstName, String lastName,
		int optIn, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByFirstNameLastNameOptIn_PrevAndNext(session,
					patientRegistration, firstName, lastName, optIn,
					orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByFirstNameLastNameOptIn_PrevAndNext(session,
					patientRegistration, firstName, lastName, optIn,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByFirstNameLastNameOptIn_PrevAndNext(
		Session session, PatientRegistration patientRegistration,
		String firstName, String lastName, int optIn,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_2);
		}

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_2);
		}

		query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_OPTIN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (bindLastName) {
			qPos.add(lastName);
		}

		qPos.add(optIn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstNameLastNameOptIn(String firstName,
		String lastName, int optIn) throws SystemException {
		for (PatientRegistration patientRegistration : findByFirstNameLastNameOptIn(
				firstName, lastName, optIn, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where firstName = &#63; and lastName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstNameLastNameOptIn(String firstName, String lastName,
		int optIn) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAMEOPTIN;

		Object[] finderArgs = new Object[] { firstName, lastName, optIn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_OPTIN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(optIn);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_1 =
		"patientRegistration.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_2 =
		"patientRegistration.firstName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_FIRSTNAME_3 =
		"(patientRegistration.firstName IS NULL OR patientRegistration.firstName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_1 =
		"patientRegistration.lastName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_2 =
		"patientRegistration.lastName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_LASTNAME_3 =
		"(patientRegistration.lastName IS NULL OR patientRegistration.lastName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMELASTNAMEOPTIN_OPTIN_2 = "patientRegistration.optIn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstNameOptIn",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstNameOptIn",
			new String[] { String.class.getName(), Integer.class.getName() },
			PatientRegistrationModelImpl.FIRSTNAME_COLUMN_BITMASK |
			PatientRegistrationModelImpl.OPTIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIRSTNAMEOPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstNameOptIn",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the patient registrations where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameOptIn(String firstName,
		int optIn) throws SystemException {
		return findByFirstNameOptIn(firstName, optIn, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where firstName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameOptIn(String firstName,
		int optIn, int start, int end) throws SystemException {
		return findByFirstNameOptIn(firstName, optIn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where firstName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByFirstNameOptIn(String firstName,
		int optIn, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMEOPTIN;
			finderArgs = new Object[] { firstName, optIn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMEOPTIN;
			finderArgs = new Object[] {
					firstName, optIn,
					
					start, end, orderByComparator
				};
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(firstName,
							patientRegistration.getFirstName()) ||
						(optIn != patientRegistration.getOptIn())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_OPTIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				qPos.add(optIn);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameOptIn_First(String firstName,
		int optIn, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameOptIn_First(firstName,
				optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameOptIn_First(String firstName,
		int optIn, OrderByComparator orderByComparator)
		throws SystemException {
		List<PatientRegistration> list = findByFirstNameOptIn(firstName, optIn,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByFirstNameOptIn_Last(String firstName,
		int optIn, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByFirstNameOptIn_Last(firstName,
				optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByFirstNameOptIn_Last(String firstName,
		int optIn, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFirstNameOptIn(firstName, optIn);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByFirstNameOptIn(firstName, optIn,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where firstName = &#63; and optIn = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByFirstNameOptIn_PrevAndNext(
		long patientRegistrationId, String firstName, int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByFirstNameOptIn_PrevAndNext(session,
					patientRegistration, firstName, optIn, orderByComparator,
					true);

			array[1] = patientRegistration;

			array[2] = getByFirstNameOptIn_PrevAndNext(session,
					patientRegistration, firstName, optIn, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByFirstNameOptIn_PrevAndNext(
		Session session, PatientRegistration patientRegistration,
		String firstName, int optIn, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_2);
		}

		query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_OPTIN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		qPos.add(optIn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where firstName = &#63; and optIn = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFirstNameOptIn(String firstName, int optIn)
		throws SystemException {
		for (PatientRegistration patientRegistration : findByFirstNameOptIn(
				firstName, optIn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where firstName = &#63; and optIn = &#63;.
	 *
	 * @param firstName the first name
	 * @param optIn the opt in
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFirstNameOptIn(String firstName, int optIn)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIRSTNAMEOPTIN;

		Object[] finderArgs = new Object[] { firstName, optIn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_2);
			}

			query.append(_FINDER_COLUMN_FIRSTNAMEOPTIN_OPTIN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				qPos.add(optIn);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_1 = "patientRegistration.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_2 = "patientRegistration.firstName = ? AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMEOPTIN_FIRSTNAME_3 = "(patientRegistration.firstName IS NULL OR patientRegistration.firstName = '') AND ";
	private static final String _FINDER_COLUMN_FIRSTNAMEOPTIN_OPTIN_2 = "patientRegistration.optIn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastNameOptIn",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAMEOPTIN =
		new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastNameOptIn",
			new String[] { String.class.getName(), Integer.class.getName() },
			PatientRegistrationModelImpl.LASTNAME_COLUMN_BITMASK |
			PatientRegistrationModelImpl.OPTIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAMEOPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastNameOptIn",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the patient registrations where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastNameOptIn(String lastName,
		int optIn) throws SystemException {
		return findByLastNameOptIn(lastName, optIn, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where lastName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastNameOptIn(String lastName,
		int optIn, int start, int end) throws SystemException {
		return findByLastNameOptIn(lastName, optIn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where lastName = &#63; and optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByLastNameOptIn(String lastName,
		int optIn, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAMEOPTIN;
			finderArgs = new Object[] { lastName, optIn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAMEOPTIN;
			finderArgs = new Object[] {
					lastName, optIn,
					
					start, end, orderByComparator
				};
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if (!Validator.equals(lastName,
							patientRegistration.getLastName()) ||
						(optIn != patientRegistration.getOptIn())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_LASTNAMEOPTIN_OPTIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(optIn);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByLastNameOptIn_First(String lastName,
		int optIn, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByLastNameOptIn_First(lastName,
				optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByLastNameOptIn_First(String lastName,
		int optIn, OrderByComparator orderByComparator)
		throws SystemException {
		List<PatientRegistration> list = findByLastNameOptIn(lastName, optIn,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByLastNameOptIn_Last(String lastName,
		int optIn, OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByLastNameOptIn_Last(lastName,
				optIn, orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append(", optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByLastNameOptIn_Last(String lastName,
		int optIn, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLastNameOptIn(lastName, optIn);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByLastNameOptIn(lastName, optIn,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where lastName = &#63; and optIn = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByLastNameOptIn_PrevAndNext(
		long patientRegistrationId, String lastName, int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByLastNameOptIn_PrevAndNext(session,
					patientRegistration, lastName, optIn, orderByComparator,
					true);

			array[1] = patientRegistration;

			array[2] = getByLastNameOptIn_PrevAndNext(session,
					patientRegistration, lastName, optIn, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByLastNameOptIn_PrevAndNext(
		Session session, PatientRegistration patientRegistration,
		String lastName, int optIn, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_2);
		}

		query.append(_FINDER_COLUMN_LASTNAMEOPTIN_OPTIN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		qPos.add(optIn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where lastName = &#63; and optIn = &#63; from the database.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLastNameOptIn(String lastName, int optIn)
		throws SystemException {
		for (PatientRegistration patientRegistration : findByLastNameOptIn(
				lastName, optIn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where lastName = &#63; and optIn = &#63;.
	 *
	 * @param lastName the last name
	 * @param optIn the opt in
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLastNameOptIn(String lastName, int optIn)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAMEOPTIN;

		Object[] finderArgs = new Object[] { lastName, optIn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_2);
			}

			query.append(_FINDER_COLUMN_LASTNAMEOPTIN_OPTIN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				qPos.add(optIn);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_1 = "patientRegistration.lastName IS NULL AND ";
	private static final String _FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_2 = "patientRegistration.lastName = ? AND ";
	private static final String _FINDER_COLUMN_LASTNAMEOPTIN_LASTNAME_3 = "(patientRegistration.lastName IS NULL OR patientRegistration.lastName = '') AND ";
	private static final String _FINDER_COLUMN_LASTNAMEOPTIN_OPTIN_2 = "patientRegistration.optIn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOptIn",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PatientRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOptIn",
			new String[] { Integer.class.getName() },
			PatientRegistrationModelImpl.OPTIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIN = new FinderPath(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOptIn",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the patient registrations where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @return the matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByOptIn(int optIn)
		throws SystemException {
		return findByOptIn(optIn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations where optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByOptIn(int optIn, int start, int end)
		throws SystemException {
		return findByOptIn(optIn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations where optIn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param optIn the opt in
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findByOptIn(int optIn, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIN;
			finderArgs = new Object[] { optIn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIN;
			finderArgs = new Object[] { optIn, start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PatientRegistration patientRegistration : list) {
				if ((optIn != patientRegistration.getOptIn())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_OPTIN_OPTIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(optIn);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first patient registration in the ordered set where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByOptIn_First(int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByOptIn_First(optIn,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the first patient registration in the ordered set where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByOptIn_First(int optIn,
		OrderByComparator orderByComparator) throws SystemException {
		List<PatientRegistration> list = findByOptIn(optIn, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last patient registration in the ordered set where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByOptIn_Last(int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByOptIn_Last(optIn,
				orderByComparator);

		if (patientRegistration != null) {
			return patientRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("optIn=");
		msg.append(optIn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchistrationException(msg.toString());
	}

	/**
	 * Returns the last patient registration in the ordered set where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching patient registration, or <code>null</code> if a matching patient registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByOptIn_Last(int optIn,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOptIn(optIn);

		if (count == 0) {
			return null;
		}

		List<PatientRegistration> list = findByOptIn(optIn, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the patient registrations before and after the current patient registration in the ordered set where optIn = &#63;.
	 *
	 * @param patientRegistrationId the primary key of the current patient registration
	 * @param optIn the opt in
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration[] findByOptIn_PrevAndNext(
		long patientRegistrationId, int optIn,
		OrderByComparator orderByComparator)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = findByPrimaryKey(patientRegistrationId);

		Session session = null;

		try {
			session = openSession();

			PatientRegistration[] array = new PatientRegistrationImpl[3];

			array[0] = getByOptIn_PrevAndNext(session, patientRegistration,
					optIn, orderByComparator, true);

			array[1] = patientRegistration;

			array[2] = getByOptIn_PrevAndNext(session, patientRegistration,
					optIn, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PatientRegistration getByOptIn_PrevAndNext(Session session,
		PatientRegistration patientRegistration, int optIn,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATIENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_OPTIN_OPTIN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PatientRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(optIn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(patientRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PatientRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the patient registrations where optIn = &#63; from the database.
	 *
	 * @param optIn the opt in
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOptIn(int optIn) throws SystemException {
		for (PatientRegistration patientRegistration : findByOptIn(optIn,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations where optIn = &#63;.
	 *
	 * @param optIn the opt in
	 * @return the number of matching patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOptIn(int optIn) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIN;

		Object[] finderArgs = new Object[] { optIn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATIENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_OPTIN_OPTIN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(optIn);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OPTIN_OPTIN_2 = "patientRegistration.optIn = ?";

	public PatientRegistrationPersistenceImpl() {
		setModelClass(PatientRegistration.class);
	}

	/**
	 * Caches the patient registration in the entity cache if it is enabled.
	 *
	 * @param patientRegistration the patient registration
	 */
	@Override
	public void cacheResult(PatientRegistration patientRegistration) {
		EntityCacheUtil.putResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationImpl.class, patientRegistration.getPrimaryKey(),
			patientRegistration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				patientRegistration.getUuid(), patientRegistration.getGroupId()
			}, patientRegistration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PATIENTID,
			new Object[] { patientRegistration.getPatientRegistrationId() },
			patientRegistration);

		patientRegistration.resetOriginalValues();
	}

	/**
	 * Caches the patient registrations in the entity cache if it is enabled.
	 *
	 * @param patientRegistrations the patient registrations
	 */
	@Override
	public void cacheResult(List<PatientRegistration> patientRegistrations) {
		for (PatientRegistration patientRegistration : patientRegistrations) {
			if (EntityCacheUtil.getResult(
						PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PatientRegistrationImpl.class,
						patientRegistration.getPrimaryKey()) == null) {
				cacheResult(patientRegistration);
			}
			else {
				patientRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patient registrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PatientRegistrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PatientRegistrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patient registration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PatientRegistration patientRegistration) {
		EntityCacheUtil.removeResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationImpl.class, patientRegistration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(patientRegistration);
	}

	@Override
	public void clearCache(List<PatientRegistration> patientRegistrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PatientRegistration patientRegistration : patientRegistrations) {
			EntityCacheUtil.removeResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PatientRegistrationImpl.class,
				patientRegistration.getPrimaryKey());

			clearUniqueFindersCache(patientRegistration);
		}
	}

	protected void cacheUniqueFindersCache(
		PatientRegistration patientRegistration) {
		if (patientRegistration.isNew()) {
			Object[] args = new Object[] {
					patientRegistration.getUuid(),
					patientRegistration.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				patientRegistration);

			args = new Object[] { patientRegistration.getPatientRegistrationId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PATIENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PATIENTID, args,
				patientRegistration);
		}
		else {
			PatientRegistrationModelImpl patientRegistrationModelImpl = (PatientRegistrationModelImpl)patientRegistration;

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistration.getUuid(),
						patientRegistration.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					patientRegistration);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PATIENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistration.getPatientRegistrationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PATIENTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PATIENTID, args,
					patientRegistration);
			}
		}
	}

	protected void clearUniqueFindersCache(
		PatientRegistration patientRegistration) {
		PatientRegistrationModelImpl patientRegistrationModelImpl = (PatientRegistrationModelImpl)patientRegistration;

		Object[] args = new Object[] {
				patientRegistration.getUuid(), patientRegistration.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((patientRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					patientRegistrationModelImpl.getOriginalUuid(),
					patientRegistrationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { patientRegistration.getPatientRegistrationId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATIENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PATIENTID, args);

		if ((patientRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PATIENTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					patientRegistrationModelImpl.getOriginalPatientRegistrationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PATIENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PATIENTID, args);
		}
	}

	/**
	 * Creates a new patient registration with the primary key. Does not add the patient registration to the database.
	 *
	 * @param patientRegistrationId the primary key for the new patient registration
	 * @return the new patient registration
	 */
	@Override
	public PatientRegistration create(long patientRegistrationId) {
		PatientRegistration patientRegistration = new PatientRegistrationImpl();

		patientRegistration.setNew(true);
		patientRegistration.setPrimaryKey(patientRegistrationId);

		String uuid = PortalUUIDUtil.generate();

		patientRegistration.setUuid(uuid);

		return patientRegistration;
	}

	/**
	 * Removes the patient registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientRegistrationId the primary key of the patient registration
	 * @return the patient registration that was removed
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration remove(long patientRegistrationId)
		throws NoSuchistrationException, SystemException {
		return remove((Serializable)patientRegistrationId);
	}

	/**
	 * Removes the patient registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient registration
	 * @return the patient registration that was removed
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration remove(Serializable primaryKey)
		throws NoSuchistrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PatientRegistration patientRegistration = (PatientRegistration)session.get(PatientRegistrationImpl.class,
					primaryKey);

			if (patientRegistration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patientRegistration);
		}
		catch (NoSuchistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PatientRegistration removeImpl(
		PatientRegistration patientRegistration) throws SystemException {
		patientRegistration = toUnwrappedModel(patientRegistration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patientRegistration)) {
				patientRegistration = (PatientRegistration)session.get(PatientRegistrationImpl.class,
						patientRegistration.getPrimaryKeyObj());
			}

			if (patientRegistration != null) {
				session.delete(patientRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patientRegistration != null) {
			clearCache(patientRegistration);
		}

		return patientRegistration;
	}

	@Override
	public PatientRegistration updateImpl(
		com.liferay.patient.registration.model.PatientRegistration patientRegistration)
		throws SystemException {
		patientRegistration = toUnwrappedModel(patientRegistration);

		boolean isNew = patientRegistration.isNew();

		PatientRegistrationModelImpl patientRegistrationModelImpl = (PatientRegistrationModelImpl)patientRegistration;

		if (Validator.isNull(patientRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			patientRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (patientRegistration.isNew()) {
				session.save(patientRegistration);

				patientRegistration.setNew(false);
			}
			else {
				session.merge(patientRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PatientRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { patientRegistrationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalUuid(),
						patientRegistrationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						patientRegistrationModelImpl.getUuid(),
						patientRegistrationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { patientRegistrationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);

				args = new Object[] { patientRegistrationModelImpl.getFirstName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAME,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalFirstName(),
						patientRegistrationModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAME,
					args);

				args = new Object[] {
						patientRegistrationModelImpl.getFirstName(),
						patientRegistrationModelImpl.getLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAME,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);

				args = new Object[] { patientRegistrationModelImpl.getLastName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalFirstName(),
						patientRegistrationModelImpl.getOriginalLastName(),
						patientRegistrationModelImpl.getOriginalOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN,
					args);

				args = new Object[] {
						patientRegistrationModelImpl.getFirstName(),
						patientRegistrationModelImpl.getLastName(),
						patientRegistrationModelImpl.getOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMELASTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMELASTNAMEOPTIN,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMEOPTIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalFirstName(),
						patientRegistrationModelImpl.getOriginalOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMEOPTIN,
					args);

				args = new Object[] {
						patientRegistrationModelImpl.getFirstName(),
						patientRegistrationModelImpl.getOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIRSTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIRSTNAMEOPTIN,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAMEOPTIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalLastName(),
						patientRegistrationModelImpl.getOriginalOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAMEOPTIN,
					args);

				args = new Object[] {
						patientRegistrationModelImpl.getLastName(),
						patientRegistrationModelImpl.getOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTNAMEOPTIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAMEOPTIN,
					args);
			}

			if ((patientRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						patientRegistrationModelImpl.getOriginalOptIn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIN,
					args);

				args = new Object[] { patientRegistrationModelImpl.getOptIn() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIN,
					args);
			}
		}

		EntityCacheUtil.putResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PatientRegistrationImpl.class, patientRegistration.getPrimaryKey(),
			patientRegistration);

		clearUniqueFindersCache(patientRegistration);
		cacheUniqueFindersCache(patientRegistration);

		return patientRegistration;
	}

	protected PatientRegistration toUnwrappedModel(
		PatientRegistration patientRegistration) {
		if (patientRegistration instanceof PatientRegistrationImpl) {
			return patientRegistration;
		}

		PatientRegistrationImpl patientRegistrationImpl = new PatientRegistrationImpl();

		patientRegistrationImpl.setNew(patientRegistration.isNew());
		patientRegistrationImpl.setPrimaryKey(patientRegistration.getPrimaryKey());

		patientRegistrationImpl.setUuid(patientRegistration.getUuid());
		patientRegistrationImpl.setPatientRegistrationId(patientRegistration.getPatientRegistrationId());
		patientRegistrationImpl.setGroupId(patientRegistration.getGroupId());
		patientRegistrationImpl.setCompanyId(patientRegistration.getCompanyId());
		patientRegistrationImpl.setUserId(patientRegistration.getUserId());
		patientRegistrationImpl.setUserName(patientRegistration.getUserName());
		patientRegistrationImpl.setCreateDate(patientRegistration.getCreateDate());
		patientRegistrationImpl.setModifiedDate(patientRegistration.getModifiedDate());
		patientRegistrationImpl.setFirstName(patientRegistration.getFirstName());
		patientRegistrationImpl.setLastName(patientRegistration.getLastName());
		patientRegistrationImpl.setAddress1(patientRegistration.getAddress1());
		patientRegistrationImpl.setCity(patientRegistration.getCity());
		patientRegistrationImpl.setState(patientRegistration.getState());
		patientRegistrationImpl.setZipCode(patientRegistration.getZipCode());
		patientRegistrationImpl.setEmailAddr(patientRegistration.getEmailAddr());
		patientRegistrationImpl.setDob(patientRegistration.getDob());
		patientRegistrationImpl.setOptIn(patientRegistration.getOptIn());
		patientRegistrationImpl.setPhoneNumber(patientRegistration.getPhoneNumber());
		patientRegistrationImpl.setPcpFirstName(patientRegistration.getPcpFirstName());
		patientRegistrationImpl.setPcpLastName(patientRegistration.getPcpLastName());
		patientRegistrationImpl.setPcpAddress(patientRegistration.getPcpAddress());
		patientRegistrationImpl.setPcpCity(patientRegistration.getPcpCity());
		patientRegistrationImpl.setPcpState(patientRegistration.getPcpState());
		patientRegistrationImpl.setPcpZipCode(patientRegistration.getPcpZipCode());
		patientRegistrationImpl.setReferringPractice(patientRegistration.getReferringPractice());

		return patientRegistrationImpl;
	}

	/**
	 * Returns the patient registration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient registration
	 * @return the patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchistrationException, SystemException {
		PatientRegistration patientRegistration = fetchByPrimaryKey(primaryKey);

		if (patientRegistration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patientRegistration;
	}

	/**
	 * Returns the patient registration with the primary key or throws a {@link com.liferay.patient.registration.NoSuchistrationException} if it could not be found.
	 *
	 * @param patientRegistrationId the primary key of the patient registration
	 * @return the patient registration
	 * @throws com.liferay.patient.registration.NoSuchistrationException if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration findByPrimaryKey(long patientRegistrationId)
		throws NoSuchistrationException, SystemException {
		return findByPrimaryKey((Serializable)patientRegistrationId);
	}

	/**
	 * Returns the patient registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient registration
	 * @return the patient registration, or <code>null</code> if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PatientRegistration patientRegistration = (PatientRegistration)EntityCacheUtil.getResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PatientRegistrationImpl.class, primaryKey);

		if (patientRegistration == _nullPatientRegistration) {
			return null;
		}

		if (patientRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				patientRegistration = (PatientRegistration)session.get(PatientRegistrationImpl.class,
						primaryKey);

				if (patientRegistration != null) {
					cacheResult(patientRegistration);
				}
				else {
					EntityCacheUtil.putResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PatientRegistrationImpl.class, primaryKey,
						_nullPatientRegistration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PatientRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PatientRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patientRegistration;
	}

	/**
	 * Returns the patient registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientRegistrationId the primary key of the patient registration
	 * @return the patient registration, or <code>null</code> if a patient registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PatientRegistration fetchByPrimaryKey(long patientRegistrationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)patientRegistrationId);
	}

	/**
	 * Returns all the patient registrations.
	 *
	 * @return the patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patient registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @return the range of patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patient registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.patient.registration.model.impl.PatientRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patient registrations
	 * @param end the upper bound of the range of patient registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PatientRegistration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PatientRegistration> list = (List<PatientRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATIENTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENTREGISTRATION;

				if (pagination) {
					sql = sql.concat(PatientRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PatientRegistration>(list);
				}
				else {
					list = (List<PatientRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the patient registrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PatientRegistration patientRegistration : findAll()) {
			remove(patientRegistration);
		}
	}

	/**
	 * Returns the number of patient registrations.
	 *
	 * @return the number of patient registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PATIENTREGISTRATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the patient registration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.patient.registration.model.PatientRegistration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PatientRegistration>> listenersList = new ArrayList<ModelListener<PatientRegistration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PatientRegistration>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PatientRegistrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATIENTREGISTRATION = "SELECT patientRegistration FROM PatientRegistration patientRegistration";
	private static final String _SQL_SELECT_PATIENTREGISTRATION_WHERE = "SELECT patientRegistration FROM PatientRegistration patientRegistration WHERE ";
	private static final String _SQL_COUNT_PATIENTREGISTRATION = "SELECT COUNT(patientRegistration) FROM PatientRegistration patientRegistration";
	private static final String _SQL_COUNT_PATIENTREGISTRATION_WHERE = "SELECT COUNT(patientRegistration) FROM PatientRegistration patientRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patientRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PatientRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PatientRegistration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PatientRegistrationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "state"
			});
	private static PatientRegistration _nullPatientRegistration = new PatientRegistrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PatientRegistration> toCacheModel() {
				return _nullPatientRegistrationCacheModel;
			}
		};

	private static CacheModel<PatientRegistration> _nullPatientRegistrationCacheModel =
		new CacheModel<PatientRegistration>() {
			@Override
			public PatientRegistration toEntityModel() {
				return _nullPatientRegistration;
			}
		};
}