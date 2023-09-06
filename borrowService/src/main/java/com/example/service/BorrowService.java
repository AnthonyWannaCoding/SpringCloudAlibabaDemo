package com.example.service;

import com.example.entity.UserBorrowDetail;

public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(int uid);
}
