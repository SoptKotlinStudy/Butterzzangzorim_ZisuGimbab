# SOPT 28th - Android 01.필수 과제

![1  1李__몃___怨쇱젣(_몃_____怨쇱젣 _댁슜 鍮쇨퀬 肄붾뱶由щ럭 諛⑹떇_대옉 泥④_)1024_1](https://user-images.githubusercontent.com/70841402/114307613-68d2cd80-9b1b-11eb-91b9-8699ab2ebf4e.jpg)

## MainActivity

![image](https://user-images.githubusercontent.com/70841402/114307107-24463280-9b19-11eb-95d1-95bc689a0c12.png)

* **ConstraintLayout**을 이용하여 '이름 입력 뷰 그룹', '깃허브 아이디 뷰 그룹', 그리고 '비밀번호 뷰 그룹'으로 나누어 구성했다.
* 로그인 버튼을 눌렀을 때, 
  - if문을 통해 '깃허브 아이디 EditText'와 '비밀번호 EditText'가 비어있지 않으면 HomeActivity로 이동하고, **Toast**로 '로그인 성공'이라는 문자를 띄운다.
  - 반대로 둘 중 어느 것이라도 비어있으면 **Toast**로 '아이디/비밀번호를 확인해주세요!'라는 문자를 띄운다.
  - 비밀번호 입력시, **android:inputType="textPassword"** 를 이용하여 입력 내용이 가려지도록 했다.
* 회원가입 버튼을 눌렀을 때, 
  - **onActivityResult**를 이용하여 SignUpActivity로 이동한다.
  -     override fun onActivityResult(requestCode : Int, resultCode: Int,data:Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                100-> {
                    binding.loginIdInput.setText(data!!.getStringExtra("id"))
                    binding.loginPasswordInput.setText(data!!.getStringExtra("pwd"))
                }
            }
        }
    }
        
  -   companion object {private const val SIGN_UP_RESULT_CODE = 100}
    
  - requestCode 는 임의적으로 선언을 했다.



