package com.duyi.hrb.servcie;

import com.duyi.hrb.controller.RespStatusEnum;
import com.duyi.hrb.dao.UserDao;
import com.duyi.hrb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User findByName(String username) {
        return  userDao.findByName(username);
    }

    public InsertStatus addUser(String username , String password,String tel){
        User user = new User(username,password,tel);
        try {
            userDao.insertUser(user);
            return InsertStatus.SUCCESS;
        } catch (Exception e){
            User user1 = findByName(username);
            if ( null != user1 ) {
                return InsertStatus.FAIL;
            } else {
                e.printStackTrace();
                return InsertStatus.UNKNOW_ERROR;
            }

        }

    }


    public boolean del(int id){
        try{
            userDao.del(id);
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public UpdateStatus updateUser(User user) {
        try {
            userDao.update(user);
            return UpdateStatus.SUCCESS;
        } catch (Exception e){
            User user1 = findByid(user.getId());
            if ( null == user1 ) {
                return UpdateStatus.FAIL;
            } else {
                e.printStackTrace();
                return UpdateStatus.UNKNOW_ERROR;
            }

        }
    }

    private User findByid(int id) {
        return userDao.findById(id);
    }

    public enum InsertStatus{
        SUCCESS(RespStatusEnum.SUCCESS,"添加成功"),
        FAIL(RespStatusEnum.FAIL,"重复添加"),
        UNKNOW_ERROR(RespStatusEnum.FAIL,"未知错误");
        private RespStatusEnum respStatus;
        private String msg;

        InsertStatus(RespStatusEnum respStatus, String msg) {
            this.respStatus = respStatus;
            this.msg = msg;
        }

        public RespStatusEnum getRespStatus() {
            return respStatus;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum UpdateStatus{
        SUCCESS(RespStatusEnum.SUCCESS,"修改成功"),
        FAIL(RespStatusEnum.FAIL,"用户不存在"),
        UNKNOW_ERROR(RespStatusEnum.FAIL,"未知错误");
        private RespStatusEnum respStatus;
        private String msg;

        UpdateStatus(RespStatusEnum respStatus, String msg) {
            this.respStatus = respStatus;
            this.msg = msg;
        }

        public RespStatusEnum getRespStatus() {
            return respStatus;
        }

        public String getMsg() {
            return msg;
        }
    }
}
