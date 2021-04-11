# SOPT 28th - Android 01.필수 과제

![1  1李__몃___怨쇱젣(_몃_____怨쇱젣 _댁슜 鍮쇨퀬 肄붾뱶由щ럭 諛⑹떇_대옉 泥④_)1024_1](https://user-images.githubusercontent.com/70841402/114307613-68d2cd80-9b1b-11eb-91b9-8699ab2ebf4e.jpg)

## MainActivity

![image](https://user-images.githubusercontent.com/70841402/114308810-092af100-9b20-11eb-9896-578c3fa4d6fd.png)

* **ConstraintLayout**을 이용하여 '이름 입력 뷰 그룹', '깃허브 아이디 뷰 그룹', 그리고 '비밀번호 뷰 그룹'으로 나누어 구성했다.
* 로그인 버튼을 눌렀을 때, 
  - if문을 통해 '깃허브 아이디 EditText'와 '비밀번호 EditText'가 비어있지 않으면 HomeActivity로 이동하고, **Toast**로 '로그인 성공'이라는 문자를 띄운다.
  - 반대로 둘 중 어느 것이라도 비어있으면 **Toast**로 '아이디/비밀번호를 확인해주세요!'라는 문자를 띄운다.
  - 비밀번호 입력시, **android:inputType="textPassword"** 를 이용하여 입력 내용이 가려지도록 했다.
* 회원가입 텍스트를 눌렀을 때, 
  - SignUpActivity로 이동한다.
  
  private fun joinButtonClickEvent() {
        binding.joinButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

## SignUpActivity

![image](https://user-images.githubusercontent.com/70841402/114307748-eeef1400-9b1b-11eb-976e-f47ccbca8fcb.png)

* SignUp 버튼을 눌렀을 때, 
  - if문을 통해 '이름 EditText', '깃허브 아이디 EditText'와 '비밀번호 EditText'가 비어있지 않으면 **Toast**로 '빈 칸이 있는지 확인해주세요!'라는 문자를 띄운다.
  - 반대로 모든 EditText에 데이터가 있으면 putExtra를 이용해 모든 값을 intent에 넣어 전달하고 MainActivity로 돌아간다. 
  - val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                intent.putExtra("userNameExtra", signUpUserName.toString())
                intent.putExtra("userGithubExtra", userGithubID.toString())
                intent.putExtra("userSignUpPassword", userSignUpPassword.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()

## HomeActivity

![image](https://user-images.githubusercontent.com/70841402/114307865-86546700-9b1c-11eb-9e8b-9bde4e365705.png)

## 1. 화면전환 후 데이터를 가져온 로직 정리

SignUpActivity에서 MainActivity로 화면전환할 때, SignUpActivity의 '이름 EditText', '깃허브 아이디 EditText'와 '비밀번호 EditText'에 입력된 데이터를 MainActivity로 전달해야 한다. 이를 위해, onActivityResult 함수를 이용해서 requestCode가 100인 경우, Activity.RESULT_OK이면 입력한 String값을 받아와서 MainActivity의 '깃허브 아이디 EditText'와 '비밀번호 EditText'에 입력되도록 했다.

    override fun onActivityResult(requestCode : Int, resultCode: Int,data:Intent?){
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
    companion object {
        private const val SIGN_UP_RESULT_CODE = 100
    }

## 2. 생명주기를 호출하고 다른 엑티비티를 호출하면 어떻게 되나?

아래와 같이 다양한 생명주기를 호출해서 로그를 띄워보고 싶었다.

override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onPause")
    }

![image](https://user-images.githubusercontent.com/70841402/114308219-0fb86900-9b1e-11eb-8005-ff4a5cbdd5ea.png)

1차 과제 수행할 때에는 잘 돌아갔던(?) 프로젝트가 2차 세미나를 들으면서 덮어씌우자 맛이 가버려서 로그를 캡쳐할 수 없었다...

(추후에 해결해서 다시 올리겠습니다.)

## 3. 이번 과제를 통해 배운 내용

이번 과제를 수행하는 과정은 정말정말 쉽지 않았다.(ㅠㅠ) 처음 다뤄보는 코틀린과 생소한 개념과 문법들...이를 나혼자서 공부했다면 분명 의욕과 방향을 잃고 방황했을 것 같다. 하지만 안팟장님의 친절한 설명과 척척석사(?) 천사 주예의 도움으로 어떻게든 이번 과제를 마무리할 수 있었다! 보충세미나에서 다룬 변수 선언, 조건, 반복, 함수 정의 내용부터 1차 세미나에서 다룬 view & viewGroup, ConstraintLayout, View Binding, Activity, 생명주기, 화면 전화, intent, 그리고 Git 사용법까지 정말 많은 것을 배웠다. 그 중에서도 화면 전환, intent, onActivityResult 함수와 관련된 개념에 대한 이해가 부족했기 때문에 수행한 과제를 다시 살펴보며 추가적인 공부가 필요할 것 같다.
