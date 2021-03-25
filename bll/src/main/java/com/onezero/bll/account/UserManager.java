package com.onezero.bll.account;

import com.onezero.dal.UserMapper;
import com.onezero.dal.data.UserData;
import com.onezero.datastructure.Code;
import com.onezero.datastructure.GenericResult;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.datastructure.Page;
import com.onezero.model.UserTypeEnum;
import com.onezero.utils.MD5Utils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserManager {
    private static final Logger logger = LoggerFactory.getLogger(UserManager.class);
    @Autowired
    private UserMapper userMapper;

    public NoneDataResult create(User user) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (user != null) {
                if (user.getType() == null) {
                    user.setType(UserTypeEnum.NORMAL_USER.id());
                }
                user.setPassword(MD5Utils.md5Hex(user.getPassword()));
                userMapper.create(user.toData());
            }
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_INSERT_ERROR);
        }
        return result;
    }

    public NoneDataResult update(User user) {
        NoneDataResult result = new NoneDataResult();
        try {
            if (user != null) {
                user.setPassword(MD5Utils.md5Hex(user.getPassword()));
                userMapper.update(user.toData());
            }
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_UPDATE_ERROR);
        }
        return result;
    }

    public NoneDataResult delete(List<Integer> ids) {
        NoneDataResult result = new NoneDataResult();
        try {
            userMapper.delete(ids);
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_DELETE_ERROR);
        }
        return result;
    }

    public GenericResult<Page<User>> search(String email, String password, Integer type, Integer page, Integer pageSize) {
        GenericResult<Page<User>> result = new GenericResult<>();
        try {
            password =  MD5Utils.md5Hex(password);
            List<List<?>> list = userMapper.search(email, password, type, page, pageSize);
            List<UserData> dataList = (List<UserData>) list.get(0);
            List<User> users = null;
            if (CollectionUtils.isNotEmpty(dataList)) {
                users = dataList.stream().map(User::new).collect(Collectors.toList());
            }
            result.setData(new Page<>(list.get(1).get(0), users));
        } catch (Exception e) {
            logger.error("error", e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

    public GenericResult<User> getUserByEmailAndPassword(String email, String password) {
        GenericResult<User> result = new GenericResult<>();
        GenericResult<Page<User>> pageResult = search(email, password, null, 1, 1);
        if (pageResult.isNotValid()) {
            return result;
        }
        Page<User> page = pageResult.getData();
        if (CollectionUtils.isNotEmpty(page.getData())) {
            result.setData(page.getData().get(0));
        }
        return result;
    }

    public NoneDataResult resetPassword(Integer id, String password) {
        NoneDataResult result = new NoneDataResult();
        try {
            password = MD5Utils.md5Hex(password);
            userMapper.resetPassword(id, password);
        } catch (Exception e) {
            logger.error("id = {}, password = {}", e);
            result.setCode(Code.DATABASE_UPDATE_ERROR);
        }
        return result;
    }

    public NoneDataResult delete(int id) {
        return delete(Collections.singletonList(id));
    }

    public GenericResult<List<User>> getByIds(List<Integer> ids) {
        GenericResult<List<User>> result = new GenericResult<>();
        if (CollectionUtils.isEmpty(ids)) {
            return result;
        }
        try {
            List<UserData> dataList = userMapper.getByIds(ids);
            List<User> userList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(dataList)) {
                userList = dataList.stream().map(User::new).collect(Collectors.toList());
            }
            result.setData(userList);
        } catch (Exception e) {
            logger.error("ids: {}, getByIds error", ids, e);
            result.setCode(Code.DATABASE_SELECT_ERROR);
        }
        return result;
    }

    public GenericResult<User> getById(int id) {
        GenericResult<User> result = new GenericResult<>();
        if (id <= 0) {
            return result;
        }
        GenericResult<List<User>> usersResult = getByIds(Collections.singletonList(id));
        if (usersResult.isNotValid()) {
            result.setCode(usersResult.getCode());
            return result;
        }
        result.setData(usersResult.getData().get(0));
        return result;
    }

}
