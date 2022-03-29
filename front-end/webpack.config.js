const path = require("path");
const CopyPLugin = require("copy-webpack-plugin");
const { webpack } = require("webpack");

module.exports = {
  mode: "production",
  entry: {
    app: "./src/app.ts",
    "perfil-empresa": "./src/perfil-empresa.ts",
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
