import React, { useContext, useState, useEffect, useCallback } from 'react';
import axios from "axios";
import { Redirect } from 'react-router-dom';
import { useForm, Controller } from 'react-hook-form';
import { MdLockOpen } from 'react-icons/md';
import { Input, Switch, Button } from 'antd';
import { FormControl } from 'components/index';
import { AuthContext } from 'context/index';
import { FieldWrapper, SwitchWrapper, Label } from 'container/Auth/Auth.style';
import {TextField} from '@material-ui/core'

const SignUpForm = () => {
  const {control} = useForm();
  const [userRegister, setUserRegister ] = useState({
    username : "",
    password : "",
    name : "",
    email : "",
    gender : "",
    birthday : "",
    phoneNumber : "",
    preferGenre : ""
  })
  const {username, password, name, email, gender, birthday, phoneNumber, preferGenre} = userRegister
  const onChange = useCallback(e => {
    setUserRegister({...userRegister, [e.target.name]: e.target.value})
  })

  const register = e => {
    e.preventDefault()
    axios({
      url: `http://localhost:8080/users/signup`,
      method: 'post',
      headers: {'Content-Type': 'application/json', 'Authorization' : 'JWT fefege..'},
      data: {username, password, name, email, gender, birthday, phoneNumber, preferGenre}
    })
      .then(resp => {
      alert('회원가입 성공'+resp.data)
    })
    .catch(err => {
      alert('회원가입 실패')
    })
  }

  return (
    <form onSubmit={e => e.preventDefault()}>
      <FormControl
        label="ID"
      >
        <Input
            onChange = {onChange}
          id="username" 
          name="username" value={username}
          defaultValue=""
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="비밀번호"
      >
        <Input
            onChange = {onChange}
          id="password"
          name="password" value={password}
          defaultValue=""
          control={control}
          rules={{ required: true, minLength: 6, maxLength: 20 }}
        />
      </FormControl>
      <FormControl
        label="이름"
      >
        <Input
            onChange = {onChange}
          id="name" 
          name="name" value={name}
          defaultValue=""
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="이메일 주소"
      >
        <Input
            onChange = {onChange}
          id="email" 
          type="email"
          name="email" value={email}
          defaultValue=""
          placeholder="ex) saram@gmail.com"
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="성별"
      >
        <Input
            onChange = {onChange}
          id="gender" 
          name="gender" value={gender}
          placeholder="남 혹은 여 라고 입력해주세요"
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="생년월일"
      >
        <Input
            onChange = {onChange}
          id="birthday" 
          name="birthday" value={birthday}
          placeholder="ex) 19960731"
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="휴대폰 번호"
      >
        <Input
            onChange = {onChange}
          id="phoneNumber" 
          name="phoneNumber" value={phoneNumber}
          defaultValue=""
          placeholder="ex) 01012345678"
          control={control}
          rules={{ required: true }}
        />
      </FormControl>
      <FormControl
        label="선호장르"
      >
         <label>
          선호장르 입력:
          <select name="preferGenre" value={preferGenre} onChange = {onChange}>
            <option value="painting">회화</option>
            <option value="installation">설치</option>
            <option value="media">미디어</option>
            <option value="sculpture">조각</option>
            <option value="craft">공예</option>
          </select>
        </label>
      </FormControl>
      <FieldWrapper>
        <SwitchWrapper>
          <Input
            as={<Switch />}
            name="rememberMe"
            defaultValue={false}
            valueName="checked"
          />
          <Label>아이디 기억하기</Label>
        </SwitchWrapper>
        <SwitchWrapper>
          <Input
            as={<Switch />}
            name="termsAndConditions"
            defaultValue={false}
            valueName="checked"
          />
          <Label>전체 약관에 동의합니다</Label>
        </SwitchWrapper>
      </FieldWrapper>

      <Button
        className="signin-btn"
        type="primary submit"
        htmlType="submit"
        size="large"
        style={{ width: '100%' }}
        onClick= {register}
      >
        <MdLockOpen />
        회원가입
      </Button>
    </form>
  );
};

export default SignUpForm;