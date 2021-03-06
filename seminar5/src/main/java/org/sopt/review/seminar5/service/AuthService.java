package org.sopt.review.seminar5.service;

        import org.sopt.review.seminar5.dto.User;
        import org.sopt.review.seminar5.mapper.UserMapper;
        import org.sopt.review.seminar5.model.DefaultRes;
        import org.sopt.review.seminar5.model.LoginReq;
        import org.sopt.review.seminar5.utils.ResponseMessage;
        import org.sopt.review.seminar5.utils.StatusCode;
        import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2018-11-21.
 */

@Service
public class AuthService {
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public AuthService(final UserMapper userMapper, final JwtService jwtService) {
        this.userMapper= userMapper;
        this.jwtService = jwtService;
    }

    /**
     * 로그인 서비스
     * @param loginReq
     *      로그인 객체
     * @return DefaultRes
     */
    public DefaultRes<JwtService.TokenRes> login(final LoginReq loginReq) {
        final User user = userMapper.findByNameAndPassword(loginReq.getName(), loginReq.getPassword());
        if(user != null) {
            // 토큰 생성
            final JwtService.TokenRes tokenDto = new JwtService.TokenRes(jwtService.create(user.getUserIdx()));
            return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, tokenDto);
        }
        return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL);
    }
}
