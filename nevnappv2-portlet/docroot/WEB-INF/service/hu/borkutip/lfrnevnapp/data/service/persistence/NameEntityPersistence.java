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

package hu.borkutip.lfrnevnapp.data.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import hu.borkutip.lfrnevnapp.data.model.NameEntity;

/**
 * The persistence interface for the name entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Péter Borkuti
 * @see NameEntityPersistenceImpl
 * @see NameEntityUtil
 * @generated
 */
public interface NameEntityPersistence extends BasePersistence<NameEntity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NameEntityUtil} to access the name entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the name entity in the entity cache if it is enabled.
	*
	* @param nameEntity the name entity
	*/
	public void cacheResult(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity);

	/**
	* Caches the name entities in the entity cache if it is enabled.
	*
	* @param nameEntities the name entities
	*/
	public void cacheResult(
		java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> nameEntities);

	/**
	* Creates a new name entity with the primary key. Does not add the name entity to the database.
	*
	* @param nameId the primary key for the new name entity
	* @return the new name entity
	*/
	public hu.borkutip.lfrnevnapp.data.model.NameEntity create(long nameId);

	/**
	* Removes the name entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity that was removed
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.NameEntity remove(long nameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException;

	public hu.borkutip.lfrnevnapp.data.model.NameEntity updateImpl(
		hu.borkutip.lfrnevnapp.data.model.NameEntity nameEntity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the name entity with the primary key or throws a {@link hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException} if it could not be found.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity
	* @throws hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.NameEntity findByPrimaryKey(
		long nameId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkutip.lfrnevnapp.data.NoSuchNameEntityException;

	/**
	* Returns the name entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nameId the primary key of the name entity
	* @return the name entity, or <code>null</code> if a name entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkutip.lfrnevnapp.data.model.NameEntity fetchByPrimaryKey(
		long nameId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the name entities.
	*
	* @return the name entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the name entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of name entities
	* @param end the upper bound of the range of name entities (not inclusive)
	* @return the range of name entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the name entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkutip.lfrnevnapp.data.model.impl.NameEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of name entities
	* @param end the upper bound of the range of name entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of name entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkutip.lfrnevnapp.data.model.NameEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the name entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of name entities.
	*
	* @return the number of name entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}