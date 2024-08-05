/** @type {import('next').NextConfig} */
const nextConfig = {
    experimental: {
      appDir: true,
    },
  
    images: { domains: ["placehold.co", "image.tmdb.org"] },
  }
  
  module.exports = nextConfig;