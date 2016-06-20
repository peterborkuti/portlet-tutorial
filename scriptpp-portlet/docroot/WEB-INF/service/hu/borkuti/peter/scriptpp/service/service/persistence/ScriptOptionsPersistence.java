/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package hu.borkuti.peter.scriptpp.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import hu.borkuti.peter.scriptpp.service.model.ScriptOptions;

/**
 * The persistence interface for the script options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptOptionsPersistenceImpl
 * @see ScriptOptionsUtil
 * @generated
 */
public interface ScriptOptionsPersistence extends BasePersistence<ScriptOptions> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScriptOptionsUtil} to access the script options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the script optionses where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the script optionses where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @return the range of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the script optionses where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first script options in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Returns the first script options in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script options, or <code>null</code> if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last script options in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Returns the last script options in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script options, or <code>null</code> if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the script optionses before and after the current script options in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param ScriptOptionsId the primary key of the current script options
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions[] findByG_U_PrevAndNext(
		long ScriptOptionsId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Removes all the script optionses where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of script optionses where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @return the matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U_ScriptName(
		long groupId, long userId, java.lang.String scriptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @return the range of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U_ScriptName(
		long groupId, long userId, java.lang.String scriptName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findByG_U_ScriptName(
		long groupId, long userId, java.lang.String scriptName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions findByG_U_ScriptName_First(
		long groupId, long userId, java.lang.String scriptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Returns the first script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script options, or <code>null</code> if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions fetchByG_U_ScriptName_First(
		long groupId, long userId, java.lang.String scriptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions findByG_U_ScriptName_Last(
		long groupId, long userId, java.lang.String scriptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Returns the last script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script options, or <code>null</code> if a matching script options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions fetchByG_U_ScriptName_Last(
		long groupId, long userId, java.lang.String scriptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the script optionses before and after the current script options in the ordered set where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param ScriptOptionsId the primary key of the current script options
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions[] findByG_U_ScriptName_PrevAndNext(
		long ScriptOptionsId, long groupId, long userId,
		java.lang.String scriptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Removes all the script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U_ScriptName(long groupId, long userId,
		java.lang.String scriptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of script optionses where groupId = &#63; and userId = &#63; and scriptName = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptName the script name
	* @return the number of matching script optionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U_ScriptName(long groupId, long userId,
		java.lang.String scriptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the script options in the entity cache if it is enabled.
	*
	* @param scriptOptions the script options
	*/
	public void cacheResult(
		hu.borkuti.peter.scriptpp.service.model.ScriptOptions scriptOptions);

	/**
	* Caches the script optionses in the entity cache if it is enabled.
	*
	* @param scriptOptionses the script optionses
	*/
	public void cacheResult(
		java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> scriptOptionses);

	/**
	* Creates a new script options with the primary key. Does not add the script options to the database.
	*
	* @param ScriptOptionsId the primary key for the new script options
	* @return the new script options
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions create(
		long ScriptOptionsId);

	/**
	* Removes the script options with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ScriptOptionsId the primary key of the script options
	* @return the script options that was removed
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions remove(
		long ScriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions updateImpl(
		hu.borkuti.peter.scriptpp.service.model.ScriptOptions scriptOptions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the script options with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException} if it could not be found.
	*
	* @param ScriptOptionsId the primary key of the script options
	* @return the script options
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException if a script options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions findByPrimaryKey(
		long ScriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptOptionsException;

	/**
	* Returns the script options with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ScriptOptionsId the primary key of the script options
	* @return the script options, or <code>null</code> if a script options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.ScriptOptions fetchByPrimaryKey(
		long ScriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the script optionses.
	*
	* @return the script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the script optionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @return the range of script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the script optionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of script optionses
	* @param end the upper bound of the range of script optionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of script optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.ScriptOptions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the script optionses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of script optionses.
	*
	* @return the number of script optionses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}