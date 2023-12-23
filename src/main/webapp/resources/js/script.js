let isFavorite = false;

function toggleFavorite() {
    const favoriteBtn = document.querySelector('.favorite-btn');

    isFavorite = !isFavorite;
    if (isFavorite) {
        favoriteBtn.classList.add('active');

    } else {
        favoriteBtn.classList.remove('active');

    }
}