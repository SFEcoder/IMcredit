import html2Canvas from 'html2canvas'
import JsPDF from 'jspdf'
export default {
    install (Vue, options) {
        Vue.prototype.getPdf = function (idStr, title) {
            html2Canvas(document.querySelector('#' + idStr), {
                // allowTaint: true,
                useCORS: true,
                scale: 1.8, // 提升画面质量，但是会增加文件大小
            }).then((canvas) => {
                const contentWidth = canvas.width
                const contentHeight = canvas.height

                /* 导出不分页处理 */
                const pageData = canvas.toDataURL('image/jpeg', 1.0)

                const pdfWidth = (contentWidth + 10) / 2 * 0.75
                const pdfHeight = (contentHeight + 200) / 2 * 0.75 // 500为底部留白

                const imgWidth = pdfWidth
                const imgHeight = (contentHeight / 2 * 0.75) // 内容图片这里不需要留白的距离

                const PDF = new JsPDF('', 'pt', [ pdfWidth, pdfHeight, ])
                PDF.addImage(pageData, 'jpeg', 0, 0, imgWidth, imgHeight)
                PDF.save(title + '.pdf')
            })
        }
    },
}