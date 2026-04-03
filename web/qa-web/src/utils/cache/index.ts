import { SessionStorage, Storage } from '@/utils/storage'
import CacheKey from '@/utils/cache/key'


// 缓存
class Cache {
	getUsername = (): string => {
		return Storage.getItem(CacheKey.UsernameKey) || ''
	}

	setUsername = (value: string) => {
		Storage.setItem(CacheKey.UsernameKey, value)
	}

	getToken = (): string => {
		return Storage.getItem(CacheKey.TokenKey) || ''
	}

	setToken = (value: string) => {
		Storage.setItem(CacheKey.TokenKey, value)
	}

	getTenantId = (): string => {
		return Storage.getItem(CacheKey.TenantId) || ''
	}

	setTenantId = (value: string) => {
		Storage.setItem(CacheKey.TenantId, value)
	}

	getRefreshToken = (): string => {
		return Storage.getItem(CacheKey.RefreshTokenKey) || ''
	}

	setRefreshToken = (value: string) => {
		Storage.setItem(CacheKey.RefreshTokenKey, value)
	}

	getSidebarOpened = (): boolean => {
		return Storage.getItem(CacheKey.SidebarOpenedKey) || false
	}

	setSidebarOpened = (value: boolean) => {
		Storage.setItem(CacheKey.SidebarOpenedKey, value)
	}

	getLanguage = (): string => {
		return Storage.getItem(CacheKey.LangKey) || 'zh-CN'
	}

	setLanguage = (value: string) => {
		Storage.setItem(CacheKey.LangKey, value)
	}

	getComponentSize = (): string => {
		return Storage.getItem(CacheKey.ComponentSizeKey) || 'default'
	}

	setComponentSize = (value: string) => {
		Storage.setItem(CacheKey.ComponentSizeKey, value)
	}


	removeTheme = () => {
		SessionStorage.removeItem(CacheKey.ThemeKey)
	}

	getRedirect = (): string => {
		return Storage.getItem(CacheKey.Redirect)
	}

	setRedirect = (value: string) => {
		Storage.setItem(CacheKey.Redirect, value)
	}
}

export default new Cache()
