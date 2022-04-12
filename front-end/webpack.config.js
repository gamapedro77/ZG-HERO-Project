const path = require("path");
const CopyPLugin = require("copy-webpack-plugin");
const { webpack } = require("webpack");

module.exports = {
  mode: "production",
  entry: {
    app: "./src/app.ts",
    "perfil-empresa": "./src/perfil-empresa.ts",
    "login-candidato": "./src/login-candidato.ts",
    "login-empresa": "./src/login-empresa.ts",
    "perfil-candidato": "./src/perfil-candidato.ts",
  },
  devServer: {
    static: path.join(__dirname, "out"),
    port: 3000,
    hot: true,
    liveReload: true,
  },
  output: {
    filename: "[name].min.js",
    path: path.join(__dirname, "out"),
  },
  plugins: [
    new CopyPLugin({
      patterns: [{ from: "public" }],
    }),
  ],
  resolve: {
    extensions: [".ts", ".js"],
  },
  performance: {
    hints: false,
    maxEntrypointSize: 512000,
    maxAssetSize: 512000,
  },
  module: {
    rules: [
      {
        test: /\.ts$/,
        use: "ts-loader",
        exclude: /node_modules/,
      },
    ],
  },
};
