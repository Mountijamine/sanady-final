document.addEventListener('DOMContentLoaded', function() {
    console.log("User dashboard script loaded"); // Debug line

    // Dropdown functionality
    const dropdownToggle = document.getElementById('dropdownToggle');
    const dropdownContent = document.querySelector('.dropdown-content');

    // Check if dropdown elements exist
    if (dropdownToggle && dropdownContent) {
        // Toggle dropdown when clicking the parameter icon
        dropdownToggle.addEventListener('click', function(e) {
            e.preventDefault();
            console.log("Dropdown toggle clicked"); // Debug line
            dropdownContent.classList.toggle('show');
        });

        // Close dropdown when clicking outside
        window.addEventListener('click', function(e) {
            if (!e.target.matches('.param-icon') && !e.target.matches('.fa-cog')) {
                if (dropdownContent.classList.contains('show')) {
                    dropdownContent.classList.remove('show');
                }
            }
        });
    } else {
        console.error("Dropdown elements not found"); // Debug line
    }

    // Profile Modal functionality
    const modal = document.getElementById('profileModal');
    const showProfileBtn = document.getElementById('showProfileModal');
    const closeBtn = modal ? modal.querySelector('.close') : null;

    const profileView = document.getElementById('profileView');
    const editProfileForm = document.getElementById('editProfileForm');
    const passwordForm = document.getElementById('passwordForm');

    const modifyBtn = document.getElementById('modifyBtn');
    const passwordBtn = document.getElementById('passwordBtn');
    const cancelEditBtn = document.getElementById('cancelEditBtn');
    const cancelPasswordBtn = document.getElementById('cancelPasswordBtn');

    // Check URL parameters for errors
    const urlParams = new URLSearchParams(window.location.search);
    const hasPasswordError = urlParams.get('passwordError') === 'true';
    const hasProfileError = urlParams.get('profileError') === 'true';

    // Check for flash attributes via data attributes
    const passwordError = document.body.getAttribute('data-password-error');
    const profileError = document.body.getAttribute('data-profile-error');

    // Check if modal elements exist
    if (modal && profileView) {
        // Check if we need to show error forms
        if ((hasPasswordError || passwordError) && passwordError !== 'null') {
            modal.style.display = 'block';
            profileView.style.display = 'none';
            if (editProfileForm) editProfileForm.style.display = 'none';
            if (passwordForm) passwordForm.style.display = 'block';
        } else if ((hasProfileError || profileError) && profileError !== 'null') {
            modal.style.display = 'block';
            profileView.style.display = 'none';
            if (editProfileForm) editProfileForm.style.display = 'block';
            if (passwordForm) passwordForm.style.display = 'none';
        }

        // Show modal when clicking "Modifier profil"
        if (showProfileBtn) {
            showProfileBtn.addEventListener('click', function(e) {
                e.preventDefault();
                console.log("Show profile button clicked"); // Debug line
                modal.style.display = 'block';
                // Always show the profile view first
                profileView.style.display = 'block';
                if (editProfileForm) editProfileForm.style.display = 'none';
                if (passwordForm) passwordForm.style.display = 'none';

                // Close the dropdown
                if (dropdownContent) {
                    dropdownContent.classList.remove('show');
                }
            });
        }

        // Close modal when clicking on X
        if (closeBtn) {
            closeBtn.addEventListener('click', function() {
                modal.style.display = 'none';
            });
        }

        // Close modal when clicking outside
        window.addEventListener('click', function(e) {
            if (e.target == modal) {
                modal.style.display = 'none';
            }
        });

        // Show edit profile form when clicking "Modifier" button
        if (modifyBtn && editProfileForm) {
            modifyBtn.addEventListener('click', function() {
                profileView.style.display = 'none';
                editProfileForm.style.display = 'block';
                if (passwordForm) passwordForm.style.display = 'none';
            });
        }

        // Show password form when clicking "Modifier mot de passe" button
        if (passwordBtn && passwordForm) {
            passwordBtn.addEventListener('click', function() {
                profileView.style.display = 'none';
                if (editProfileForm) editProfileForm.style.display = 'none';
                passwordForm.style.display = 'block';
            });
        }

        // Return to profile view when clicking cancel buttons
        if (cancelEditBtn) {
            cancelEditBtn.addEventListener('click', function() {
                profileView.style.display = 'block';
                if (editProfileForm) editProfileForm.style.display = 'none';
                if (passwordForm) passwordForm.style.display = 'none';
            });
        }

        if (cancelPasswordBtn) {
            cancelPasswordBtn.addEventListener('click', function() {
                profileView.style.display = 'block';
                if (editProfileForm) editProfileForm.style.display = 'none';
                if (passwordForm) passwordForm.style.display = 'none';
            });
        }
    } else {
        console.error("Modal elements not found"); // Debug line
    }
});