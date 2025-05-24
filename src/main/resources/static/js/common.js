
const header = document.querySelector('header.navbar');
const slideUpMenu = document.querySelector('div#slide_up_menu');
const menuLinks = header.querySelectorAll('a');
const menuItems = slideUpMenu.querySelectorAll('li');
const loginButtons = document.querySelectorAll('#login, #join, #myPage, #logout');
const topWrap = document.querySelector('.top_wrap');
let isMouseOverHeader = false;

// 헤더 기본 스타일 설정
header.style.position = 'fixed';
header.style.top = '0';
header.style.width = '100%';
header.style.zIndex = '1000';
header.style.transition = 'background 0.3s, height 0.3s';

// 스크롤에 따른 스타일 변경 함수
function handleScroll() {
    if (!isMouseOverHeader) {
        if (window.scrollY > 50) {
            header.style.background = 'rgba(255, 255, 255, 0.8)';
            header.style.height = '60px';
            topWrap.style.height = '60px';
            menuLinks.forEach(link => link.style.color = '#1a1a1a');
            menuItems.forEach(item => item.style.color = '#1a1a1a');
            loginButtons.forEach(button => button.style.color = '#1a1a1a');
        } else {
            header.style.background = 'rgba(255, 255, 255, 0.2)';
            header.style.height = '80px';
            topWrap.style.height = ''; // 초기값 유지
            menuLinks.forEach(link => link.style.color = 'white');
            menuItems.forEach(item => item.style.color = 'white');
            loginButtons.forEach(button => button.style.color = 'white');
        }
    }
}

// 헤더에 마우스를 올렸을 때 스타일 변경
header.addEventListener('mouseenter', () => {
    isMouseOverHeader = true;
    slideUpMenu.style.top = '60px';
    header.style.height = '320px';
    header.style.background = 'rgba(255, 255, 255, 0.9)';
    topWrap.style.height = window.scrollY > 50 ? '60px' : ''; // 스크롤 상태에 따라 유지
    menuLinks.forEach(link => link.style.color = 'black');
    menuItems.forEach(item => item.style.color = 'black');
    loginButtons.forEach(button => button.style.color = 'black');
});

// 헤더에서 마우스를 뗐을 때 스타일 복구
header.addEventListener('mouseleave', () => {
    isMouseOverHeader = false;
    slideUpMenu.style.top = '-270px';
    header.style.height = window.scrollY > 50 ? '60px' : '80px';
    header.style.background = window.scrollY > 50 ? 'rgba(255, 255, 255, 0.8)' : 'rgba(255, 255, 255, 0.2)';
    topWrap.style.height = window.scrollY > 50 ? '60px' : ''; // 스크롤 상태에 따라 유지
    menuLinks.forEach(link => link.style.color = window.scrollY > 50 ? 'black' : 'white');
    menuItems.forEach(item => item.style.color = window.scrollY > 50 ? 'black' : 'white');
    loginButtons.forEach(button => button.style.color = window.scrollY > 50 ? 'black' : 'white');
});

// 스크롤 이벤트 등록
window.addEventListener('scroll', handleScroll);

// 초기 상태 반영
handleScroll();

document.addEventListener("DOMContentLoaded", function () {
    var isLoggedIn = /*[[${session.loginUser != null}]]*/ false;
    if (isLoggedIn) {
        document.body.classList.add("logged-in");
    }
});
