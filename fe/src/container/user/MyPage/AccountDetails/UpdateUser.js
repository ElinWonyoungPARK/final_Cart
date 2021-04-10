import axios from 'axios'
import React, { useEffect, useState } from 'react' 
import { Link } from 'react-router-dom';
import { Divider, Col} from 'antd';
import Wrapper, { TextInfo, Label, Title, Input } from 'container/user/MyPage/AccountDetails/UpdateUser.style';
const UpdateUser = (props) => {
    const [ user, setUser ] = useState({})
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
    const [preferGenre, setPreferGenre] = useState('')
    const editUser = () => {
        setUser(JSON.parse(localStorage.getItem("user")))
    } 
    const URL = `http://localhost:8080/users/`
    const userEdit = e => {
        e.preventDefault()
        axios({
            url: URL+user.userNum,
            method: 'put',
            headers: {'Content-Type':'application/json','Authorization': 'Bearer '+localStorage.getItem("token")},
            data: {userNum: user.userNum, username, password, name: user.name, email, gender:user.gender, birthday:user.birthday, phoneNumber, admin:user.admin, preferGenre}
        }).then(res => {
            props.history.push('/profile')
        }).catch(err => {
            alert(err)
        })
    }
    const userDelete = e => {
        e.preventDefault()
        axios({
            url: URL+user.userNum,
            method: 'delete',
            headers: {'Content-Type':'application/json','Authorization': 'Bearer '+localStorage.getItem("token")}
        }).then(res => {
            props.history.push('/')
        }).catch(err => {
            alert(err)
        })
    }
    useEffect(()=>editUser(), [])
    return (
        <Wrapper>
        <Divider />
          <Col xl={5}>
          <div>
          <Title>회원정보수정</Title><br/>
          <Label>아이디</Label>
          <div>{user.username}</div>
          <Label>비밀번호</Label>
          <Input name="password" value={password}
            placeholder = '*******'
            onChange={e => setPassword(e.target.value)}
            required /><br/>
          <Label>이름</Label><br/>
          <div>{user.name}</div>
            <Label>이메일</Label>
          <Input name="email" value={email}
            placeholder = { user.email }
            onChange={e => setEmail(e.target.value)}
            required /><br/>
            <Label>성별</Label><br/>
            <div>{user.gender}</div>
            <Label>생년월일</Label><br/>
            <div>{user.birthday}</div>
            <Label>전화번호</Label><br/><br/>
            <br/><Input name="phoneNumber" value={phoneNumber}
            placeholder = { user.phoneNumber }
            onChange={e => setPhoneNumber(e.target.value)}
            required /><br/>
            <br/><Label>선호장르</Label><br/><br/>
          <Input name="preferGenre" value={preferGenre}
            placeholder = { user.preferGenre }
            onChange={e => setPreferGenre(e.target.value)}
            required />
          </div>
          </Col>
          <div className="container">
          <button className="btn" onClick = { userEdit }>수정</button>
          <button className="cancle-btn" onClick = { userDelete }>회원탈퇴</button>
          </div>
        <Divider> C:ART  |  Seoul Museum of Art </Divider>
      </Wrapper>
      
  
    );
}

export default UpdateUser