/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    container: {
      center: true,
      screens: {
        sm: "640px",
        md: "640px",
        lg: "640px",
        xl: "640px",
        "2xl": "640px",
      },
      padding: {
        DEFAULT: '1rem',
        sm: '2rem',
        lg: '4rem',
        xl: '5rem',
         "2xl": "6rem",
      },
    },
    extend: {},
  },
  plugins: [],
}

