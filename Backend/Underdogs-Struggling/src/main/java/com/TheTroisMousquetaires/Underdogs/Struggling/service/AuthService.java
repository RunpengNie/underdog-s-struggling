package com.TheTroisMousquetaires.Underdogs.Struggling.service;

import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
