import { defineStore } from 'pinia'
import cache from '@/utils/cache'

export const useAppStore = defineStore('appStore', {
	state: () => ({
		// 国际化
		language: cache.getLanguage(),
	}),
	actions: {

		setLanguage(locale: string) {
			this.language = locale
			cache.setLanguage(locale)
		}

	}
})
