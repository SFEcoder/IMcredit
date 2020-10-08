module.exports = {
    publicPath: './',
    devServer: {
        port: 8090
    },
    css: {
        loaderOptions: {
            less: {
                modifyVars: {
                    'primary-color': '#69004b',
                    'link-color': '#69004b',
                    'border-radius-base': '2px',
                },
                javascriptEnabled: true,
            },
        },
    },
}
