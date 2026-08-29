package com.TheTroisMousquetaires.Underdogs.Struggling.service;

import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.LoginDto;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
