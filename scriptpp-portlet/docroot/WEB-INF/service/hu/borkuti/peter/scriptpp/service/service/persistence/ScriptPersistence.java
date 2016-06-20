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

import hu.borkuti.peter.scriptpp.service.model.Script;

/**
 * The persistence interface for the script service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Borkuti
 * @see ScriptPersistenceImpl
 * @see ScriptUtil
 * @generated
 */
public interface ScriptPersistence extends BasePersistence<Script> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScriptUtil} to access the script persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @return the matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U_SOid(
		long groupId, long userId, long scriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @return the range of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U_SOid(
		long groupId, long userId, long scriptOptionsId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U_SOid(
		long groupId, long userId, long scriptOptionsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script findByG_U_SOid_First(
		long groupId, long userId, long scriptOptionsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Returns the first script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script, or <code>null</code> if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script fetchByG_U_SOid_First(
		long groupId, long userId, long scriptOptionsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script findByG_U_SOid_Last(
		long groupId, long userId, long scriptOptionsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Returns the last script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script, or <code>null</code> if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script fetchByG_U_SOid_Last(
		long groupId, long userId, long scriptOptionsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scripts before and after the current script in the ordered set where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param ScriptId the primary key of the current script
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script[] findByG_U_SOid_PrevAndNext(
		long ScriptId, long groupId, long userId, long scriptOptionsId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Removes all the scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U_SOid(long groupId, long userId, long scriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scripts where groupId = &#63; and userId = &#63; and scriptOptionsId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param scriptOptionsId the script options ID
	* @return the number of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U_SOid(long groupId, long userId, long scriptOptionsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the scripts where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the scripts where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @return the range of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scripts where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first script in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Returns the first script in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching script, or <code>null</code> if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last script in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Returns the last script in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching script, or <code>null</code> if a matching script could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the scripts before and after the current script in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param ScriptId the primary key of the current script
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script[] findByG_U_PrevAndNext(
		long ScriptId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Removes all the scripts where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scripts where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching scripts
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the script in the entity cache if it is enabled.
	*
	* @param script the script
	*/
	public void cacheResult(
		hu.borkuti.peter.scriptpp.service.model.Script script);

	/**
	* Caches the scripts in the entity cache if it is enabled.
	*
	* @param scripts the scripts
	*/
	public void cacheResult(
		java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> scripts);

	/**
	* Creates a new script with the primary key. Does not add the script to the database.
	*
	* @param ScriptId the primary key for the new script
	* @return the new script
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script create(long ScriptId);

	/**
	* Removes the script with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ScriptId the primary key of the script
	* @return the script that was removed
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script remove(long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	public hu.borkuti.peter.scriptpp.service.model.Script updateImpl(
		hu.borkuti.peter.scriptpp.service.model.Script script)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the script with the primary key or throws a {@link hu.borkuti.peter.scriptpp.service.NoSuchScriptException} if it could not be found.
	*
	* @param ScriptId the primary key of the script
	* @return the script
	* @throws hu.borkuti.peter.scriptpp.service.NoSuchScriptException if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script findByPrimaryKey(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.borkuti.peter.scriptpp.service.NoSuchScriptException;

	/**
	* Returns the script with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ScriptId the primary key of the script
	* @return the script, or <code>null</code> if a script with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.borkuti.peter.scriptpp.service.model.Script fetchByPrimaryKey(
		long ScriptId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the scripts.
	*
	* @return the scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the scripts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @return the range of scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the scripts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.borkuti.peter.scriptpp.service.model.impl.ScriptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of scripts
	* @param end the upper bound of the range of scripts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of scripts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.borkuti.peter.scriptpp.service.model.Script> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the scripts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of scripts.
	*
	* @return the number of scripts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}